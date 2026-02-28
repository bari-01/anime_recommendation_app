/*
 * AnimeRec - Anime Recommendation App
 * Copyright (C) 2025 Shuvam Banerji Seal
 *
 * Developed by: Shuvam Banerji Seal
 * GitHub: https://github.com/technicallittlemaster
 *
 * This file is part of AnimeRec.
 * Licensed under the MIT License.
 */
package com.animerec.app.ui.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.animerec.app.AnimeRecApp
import com.animerec.app.R
import com.animerec.app.data.Resource
import com.animerec.app.util.ErrorLogManager
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Fragment for selecting content and genre preferences, with advanced filters.
 * Accessible both during onboarding and from the profile screen.
 * 
 * Genres are fetched dynamically from the user's MAL anime list and
 * combined with the comprehensive MAL genre catalogue. This ensures
 * all MAL genres are available, prioritised by what the user has watched.
 */
class PreferencesFragment : Fragment() {
    
    private val TAG = "PreferencesFragment"

    /**
     * Comprehensive MAL genre catalogue, grouped by category.
     * These are the official MAL genre IDs/names — used as fallback
     * when the API doesn't return additional genres.
     */
    private val malGenresByCategory = mapOf(
        "Genres" to listOf(
            "Action", "Adventure", "Avant Garde", "Award Winning",
            "Boys Love", "Comedy", "Drama", "Ecchi",
            "Fantasy", "Girls Love", "Gourmet", "Horror",
            "Mystery", "Romance", "Sci-Fi", "Slice of Life",
            "Sports", "Supernatural", "Suspense"
        ),
        "Themes" to listOf(
            "Adult Cast", "Anthropomorphic", "CGDCT", "Childcare",
            "Combat Sports", "Crossdressing", "Delinquents", "Detective",
            "Educational", "Gag Humor", "Gore", "Harem",
            "High Stakes Game", "Historical", "Idols (Female)", "Idols (Male)",
            "Isekai", "Iyashikei", "Love Polygon", "Magical Sex Shift",
            "Mahou Shoujo", "Martial Arts", "Mecha", "Medical",
            "Military", "Music", "Mythology", "Organized Crime",
            "Otaku Culture", "Parody", "Performing Arts", "Pets",
            "Psychological", "Racing", "Reincarnation", "Reverse Harem",
            "Romantic Subtext", "Samurai", "School", "Showbiz",
            "Space", "Strategy Game", "Super Power", "Survival",
            "Team Sports", "Time Travel", "Vampire", "Video Game",
            "Visual Arts", "Workplace"
        ),
        "Demographics" to listOf(
            "Josei", "Kids", "Seinen", "Shoujo", "Shounen"
        )
    )

    private val contentTypes = listOf("anime", "manga", "novels")
    
    private val airingStatuses = listOf(
        "currently_airing" to "Currently Airing",
        "finished_airing" to "Finished Airing",
        "not_yet_aired" to "Not Yet Aired"
    )
    
    private val selectedGenres = mutableListOf<String>()
    private val selectedContentTypes = mutableListOf("anime")
    private val selectedAiringStatuses = mutableListOf<String>()
    private var minimumRating = 0.0

    /** Genres discovered from user's MAL list (populated async) */
    private val userDiscoveredGenres = mutableSetOf<String>()
    
    /** True when opened during initial setup (from profileSetupFragment) */
    private val isOnboarding: Boolean
        get() {
            return try {
                val backStackCount = findNavController().previousBackStackEntry?.destination?.id
                backStackCount == R.id.profileSetupFragment
            } catch (e: Exception) {
                false
            }
        }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_preferences, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ErrorLogManager.logEvent(TAG, "LIFECYCLE", "onViewCreated — isOnboarding=$isOnboarding")

        val genreContainer = view.findViewById<ChipGroup>(R.id.genre_container)
        val contentTypeContainer = view.findViewById<ChipGroup>(R.id.content_type_container)
        val saveButton = view.findViewById<Button>(R.id.btn_save_preferences)

        // Load previously saved preferences
        loadSavedPreferences()

        // Add content type chips
        for (type in contentTypes) {
            val chip = Chip(requireContext()).apply {
                text = type.replaceFirstChar { it.uppercase() }
                isCheckable = true
                isChecked = type in selectedContentTypes
                setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        if (type !in selectedContentTypes) selectedContentTypes.add(type)
                    } else {
                        selectedContentTypes.remove(type)
                    }
                }
            }
            contentTypeContainer.addView(chip)
        }

        // Populate genres from the MAL catalogue (grouped by category)
        populateGenreChips(genreContainer)

        // Asynchronously fetch user's genres from MAL and merge
        fetchUserGenresAsync(genreContainer)

        // ── Advanced Filters Section ──
        val parentLayout = genreContainer.parent as LinearLayout

        // Add airing status filter section
        val airingLabel = TextView(requireContext()).apply {
            text = "Airing Status Filter"
            textSize = 18f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(0, 48, 0, 16)
        }
        val airingSubtitle = TextView(requireContext()).apply {
            text = "Leave empty to show all statuses"
            textSize = 14f
            setPadding(0, 0, 0, 8)
        }

        parentLayout.addView(airingLabel)
        parentLayout.addView(airingSubtitle)

        val airingChipGroup = ChipGroup(requireContext())
        for ((statusKey, statusLabel) in airingStatuses) {
            val chip = Chip(requireContext()).apply {
                text = statusLabel
                isCheckable = true
                isChecked = statusKey in selectedAiringStatuses
                setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        if (statusKey !in selectedAiringStatuses) selectedAiringStatuses.add(statusKey)
                    } else {
                        selectedAiringStatuses.remove(statusKey)
                    }
                }
            }
            airingChipGroup.addView(chip)
        }
        parentLayout.addView(airingChipGroup)
        
        // Add minimum rating slider
        val ratingLabel = TextView(requireContext()).apply {
            text = "Minimum MAL Score"
            textSize = 18f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(0, 48, 0, 16)
        }
        val ratingValue = TextView(requireContext()).apply {
            text = "Minimum: ${String.format("%.1f", minimumRating)}"
            textSize = 14f
        }
        val ratingSeekBar = SeekBar(requireContext()).apply {
            max = 100  // 0.0 to 10.0 in 0.1 steps
            progress = (minimumRating * 10).toInt()
            setPadding(0, 16, 0, 32)
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    minimumRating = progress / 10.0
                    ratingValue.text = "Minimum: ${String.format("%.1f", minimumRating)}"
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })
        }
        
        parentLayout.addView(ratingLabel)
        parentLayout.addView(ratingValue)
        parentLayout.addView(ratingSeekBar)
        
        // Move save button to the end (remove and re-add)
        parentLayout.removeView(saveButton)
        parentLayout.addView(saveButton)
        
        saveButton.setOnClickListener {
            if (selectedContentTypes.isEmpty()) {
                Toast.makeText(requireContext(), "Please select at least one content type", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            if (selectedGenres.isEmpty()) {
                Toast.makeText(requireContext(), "Please select at least one genre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            // Save preferences
            savePreferences()
            ErrorLogManager.logEvent(TAG, "PREFS", "Saved preferences — genres=${selectedGenres.size}, types=${selectedContentTypes.size}")
            
            Toast.makeText(requireContext(), "Preferences saved!", Toast.LENGTH_SHORT).show()
            
            if (isOnboarding) {
                findNavController().navigate(R.id.action_preferencesFragment_to_homeFragment)
            } else {
                findNavController().popBackStack()
            }
        }
    }

    /**
     * Populate genre chips from the MAL catalogue, grouped by category.
     */
    private fun populateGenreChips(genreContainer: ChipGroup) {
        val parentLayout = genreContainer.parent as LinearLayout
        val genreContainerIndex = parentLayout.indexOfChild(genreContainer)

        // Remove the original genre_container — we'll add categorised groups instead
        // Actually, keep it and use it for the first category
        genreContainer.removeAllViews()

        var isFirst = true
        for ((category, genres) in malGenresByCategory) {
            if (!isFirst) {
                // Add a category label above each section
                val categoryLabel = TextView(requireContext()).apply {
                    text = category
                    textSize = 14f
                    setTypeface(null, android.graphics.Typeface.BOLD)
                    setPadding(0, 24, 0, 8)
                    setTextColor(resources.getColor(R.color.purple_500, null))
                }
                parentLayout.addView(categoryLabel, parentLayout.indexOfChild(genreContainer) + 1)

                val chipGroup = ChipGroup(requireContext())
                for (genre in genres) {
                    chipGroup.addView(createGenreChip(genre))
                }
                parentLayout.addView(chipGroup, parentLayout.indexOfChild(categoryLabel) + 1)
            } else {
                // First category uses the existing genreContainer
                val categoryLabel = TextView(requireContext()).apply {
                    text = category
                    textSize = 14f
                    setTypeface(null, android.graphics.Typeface.BOLD)
                    setPadding(0, 8, 0, 8)
                    setTextColor(resources.getColor(R.color.purple_500, null))
                }
                parentLayout.addView(categoryLabel, genreContainerIndex)
                
                for (genre in genres) {
                    genreContainer.addView(createGenreChip(genre))
                }
                isFirst = false
            }
        }
    }

    /**
     * Create a genre chip with proper styling and selection handling.
     */
    private fun createGenreChip(genre: String): Chip {
        return Chip(requireContext()).apply {
            text = genre
            isCheckable = true
            isChecked = genre in selectedGenres
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (genre !in selectedGenres) selectedGenres.add(genre)
                } else {
                    selectedGenres.remove(genre)
                }
            }
        }
    }

    /**
     * Fetch genres from the user's actual MAL anime list and add any
     * genres not already in the static catalogue.
     */
    private fun fetchUserGenresAsync(genreContainer: ChipGroup) {
        val app = requireActivity().application as? AnimeRecApp ?: return
        val repository = app.repository

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                ErrorLogManager.logEvent(TAG, "GENRES", "Fetching user's genres from MAL...")
                val result = withContext(Dispatchers.IO) {
                    repository.getUserAnimeList(null)
                }
                if (result is Resource.Success) {
                    val apiGenres = result.data
                        .flatMap { it.genres }
                        .distinct()
                        .sorted()
                    
                    // Find genres from API that aren't in our catalogue
                    val allCatalogueGenres = malGenresByCategory.values.flatten().toSet()
                    val newGenres = apiGenres.filter { it !in allCatalogueGenres }
                    
                    if (newGenres.isNotEmpty()) {
                        ErrorLogManager.logEvent(TAG, "GENRES", "Discovered ${newGenres.size} additional genres from user list: $newGenres")
                        userDiscoveredGenres.addAll(newGenres)
                        
                        // Add discovered genres as a new section
                        val parentLayout = genreContainer.parent as LinearLayout
                        val label = TextView(requireContext()).apply {
                            text = "From Your List"
                            textSize = 14f
                            setTypeface(null, android.graphics.Typeface.BOLD)
                            setPadding(0, 24, 0, 8)
                            setTextColor(resources.getColor(R.color.teal_700, null))
                        }
                        val chipGroup = ChipGroup(requireContext())
                        for (genre in newGenres) {
                            chipGroup.addView(createGenreChip(genre))
                        }
                        
                        // Find position before the save button
                        val saveButton = view?.findViewById<Button>(R.id.btn_save_preferences)
                        val saveIdx = if (saveButton != null) parentLayout.indexOfChild(saveButton) else parentLayout.childCount
                        parentLayout.addView(label, saveIdx)
                        parentLayout.addView(chipGroup, saveIdx + 1)
                    }
                    
                    ErrorLogManager.logEvent(TAG, "GENRES", "Total available genres: ${allCatalogueGenres.size + newGenres.size}")
                }
            } catch (e: Exception) {
                Log.w(TAG, "Failed to fetch user genres from MAL (non-fatal)", e)
                ErrorLogManager.logEvent(TAG, "GENRES", "Genre fetch failed: ${e.message}")
            }
        }
    }
    
    private fun loadSavedPreferences() {
        val prefs = requireContext().getSharedPreferences("anime_repo_prefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val listType = object : TypeToken<List<String>>() {}.type
        
        try {
            val contentJson = prefs.getString("content_preferences", null)
            if (contentJson != null) {
                val saved: List<String> = gson.fromJson(contentJson, listType)
                selectedContentTypes.clear()
                selectedContentTypes.addAll(saved)
            }
            
            val genreJson = prefs.getString("genre_preferences", null)
            if (genreJson != null) {
                val saved: List<String> = gson.fromJson(genreJson, listType)
                selectedGenres.clear()
                selectedGenres.addAll(saved)
            }
            
            val airingJson = prefs.getString("airing_status_preferences", null)
            if (airingJson != null) {
                val saved: List<String> = gson.fromJson(airingJson, listType)
                selectedAiringStatuses.clear()
                selectedAiringStatuses.addAll(saved)
            }
            
            minimumRating = prefs.getFloat("minimum_rating", 0f).toDouble()
            ErrorLogManager.logEvent(TAG, "PREFS", "Loaded saved preferences — genres=${selectedGenres.size}, types=${selectedContentTypes.size}")
        } catch (e: Exception) {
            Log.w(TAG, "Error loading saved preferences", e)
        }
    }
    
    private fun savePreferences() {
        val prefs = requireContext().getSharedPreferences("anime_repo_prefs", Context.MODE_PRIVATE)
        val gson = Gson()
        prefs.edit()
            .putString("content_preferences", gson.toJson(selectedContentTypes))
            .putString("genre_preferences", gson.toJson(selectedGenres))
            .putString("airing_status_preferences", gson.toJson(selectedAiringStatuses))
            .putFloat("minimum_rating", minimumRating.toFloat())
            .putBoolean("profile_complete", true)
            .apply()
    }
}
