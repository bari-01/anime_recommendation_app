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

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Space
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.animerec.app.R
import com.animerec.app.data.Resource
import com.animerec.app.models.AnimeStatistics
import com.animerec.app.models.User
import com.animerec.app.util.ErrorLogManager
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

/**
 * Fragment displaying comprehensive MyAnimeList profile stats.
 */
class MalStatsFragment : Fragment() {

    private val TAG = "MalStatsFragment"
    private lateinit var viewModel: ProfileViewModel

    // UI components — nullable to allow cleanup in onDestroyView
    private var loadingIndicator: ProgressBar? = null
    private var errorTextView: TextView? = null
    private var profilePictureImageView: ImageView? = null
    private var userNameTextView: TextView? = null
    private var joinedDateTextView: TextView? = null
    private var locationTextView: TextView? = null
    private var totalEntriesValue: TextView? = null
    private var meanScoreValue: TextView? = null
    private var episodesWatchedValue: TextView? = null
    private var watchingCount: TextView? = null
    private var completedCount: TextView? = null
    private var onHoldCount: TextView? = null
    private var droppedCount: TextView? = null
    private var planToWatchCount: TextView? = null
    private var statusBarContainer: LinearLayout? = null
    private var daysWatchedValue: TextView? = null
    private var daysWatchingValue: TextView? = null
    private var rewatchedValue: TextView? = null
    private var contentTypesChipGroup: ChipGroup? = null
    private var genresChipGroup: ChipGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Share the ViewModel with ProfileFragment so data is already loaded
        viewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mal_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize UI components
        loadingIndicator = view.findViewById(R.id.loadingIndicator)
        errorTextView = view.findViewById(R.id.errorTextView)
        profilePictureImageView = view.findViewById(R.id.profilePictureImageView)
        userNameTextView = view.findViewById(R.id.userNameTextView)
        joinedDateTextView = view.findViewById(R.id.joinedDateTextView)
        locationTextView = view.findViewById(R.id.locationTextView)
        totalEntriesValue = view.findViewById(R.id.totalEntriesValue)
        meanScoreValue = view.findViewById(R.id.meanScoreValue)
        episodesWatchedValue = view.findViewById(R.id.episodesWatchedValue)
        watchingCount = view.findViewById(R.id.watchingCount)
        completedCount = view.findViewById(R.id.completedCount)
        onHoldCount = view.findViewById(R.id.onHoldCount)
        droppedCount = view.findViewById(R.id.droppedCount)
        planToWatchCount = view.findViewById(R.id.planToWatchCount)
        statusBarContainer = view.findViewById(R.id.statusBarContainer)
        daysWatchedValue = view.findViewById(R.id.daysWatchedValue)
        daysWatchingValue = view.findViewById(R.id.daysWatchingValue)
        rewatchedValue = view.findViewById(R.id.rewatchedValue)
        contentTypesChipGroup = view.findViewById(R.id.contentTypesChipGroup)
        genresChipGroup = view.findViewById(R.id.genresChipGroup)

        ErrorLogManager.logEvent(TAG, "LIFECYCLE", "onViewCreated")

        // Observe user profile
        viewModel.userProfile.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    loadingIndicator?.visibility = View.VISIBLE
                    errorTextView?.visibility = View.GONE
                }
                is Resource.Success -> {
                    loadingIndicator?.visibility = View.GONE
                    errorTextView?.visibility = View.GONE
                    populateProfile(resource.data)
                    populateStats(resource.data.animeStatistics)
                    populatePreferences(resource.data)
                    ErrorLogManager.logEvent(TAG, "DATA", "Profile loaded: ${resource.data.name}")
                }
                is Resource.Error -> {
                    loadingIndicator?.visibility = View.GONE
                    errorTextView?.visibility = View.VISIBLE
                    errorTextView?.text = resource.message
                    ErrorLogManager.logEvent(TAG, "ERROR", "Failed to load stats: ${resource.message}")
                }
            }
        }

        // If profile is not yet loaded, trigger a load
        if (viewModel.userProfile.value == null) {
            viewModel.loadUserProfile()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        ErrorLogManager.logEvent(TAG, "LIFECYCLE", "onDestroyView — nulling 20 view refs")
        loadingIndicator = null
        errorTextView = null
        profilePictureImageView = null
        userNameTextView = null
        joinedDateTextView = null
        locationTextView = null
        totalEntriesValue = null
        meanScoreValue = null
        episodesWatchedValue = null
        watchingCount = null
        completedCount = null
        onHoldCount = null
        droppedCount = null
        planToWatchCount = null
        statusBarContainer = null
        daysWatchedValue = null
        daysWatchingValue = null
        rewatchedValue = null
        contentTypesChipGroup = null
        genresChipGroup = null
    }

    private fun populateProfile(user: User) {
        userNameTextView?.text = user.name

        if (!user.profilePictureUrl.isNullOrEmpty()) {
            profilePictureImageView?.let {
                Glide.with(this)
                    .load(user.profilePictureUrl)
                    .circleCrop()
                    .into(it)
            }
        }

        if (user.joinedAt.isNotEmpty()) {
            joinedDateTextView?.text = "Member since ${user.joinedAt}"
            joinedDateTextView?.visibility = View.VISIBLE
        } else {
            joinedDateTextView?.visibility = View.GONE
        }

        if (user.location.isNotEmpty()) {
            locationTextView?.text = user.location
            locationTextView?.visibility = View.VISIBLE
        } else {
            locationTextView?.visibility = View.GONE
        }
    }

    private fun populateStats(stats: AnimeStatistics) {
        // Overview numbers
        totalEntriesValue?.text = stats.numItems.toString()
        meanScoreValue?.text = String.format("%.1f", stats.meanScore)
        episodesWatchedValue?.text = stats.numEpisodes.toString()

        // Status counts
        watchingCount?.text = stats.numItemsWatching.toString()
        completedCount?.text = stats.numItemsCompleted.toString()
        onHoldCount?.text = stats.numItemsOnHold.toString()
        droppedCount?.text = stats.numItemsDropped.toString()
        planToWatchCount?.text = stats.numItemsPlanToWatch.toString()

        // Build the stacked status bar
        buildStatusBar(stats)

        // Time stats
        daysWatchedValue?.text = String.format("%.1f", stats.numDaysWatched + stats.numDaysCompleted)
        daysWatchingValue?.text = String.format("%.1f", stats.numDaysWatching)
        rewatchedValue?.text = stats.numTimesRewatched.toString()
    }

    private fun buildStatusBar(stats: AnimeStatistics) {
        statusBarContainer?.removeAllViews() ?: return
        val total = stats.numItems.toFloat().coerceAtLeast(1f)

        data class StatusSegment(val count: Int, val color: Int)

        val segments = listOf(
            StatusSegment(stats.numItemsWatching, Color.parseColor("#4CAF50")),
            StatusSegment(stats.numItemsCompleted, Color.parseColor("#2196F3")),
            StatusSegment(stats.numItemsOnHold, Color.parseColor("#FFC107")),
            StatusSegment(stats.numItemsDropped, Color.parseColor("#F44336")),
            StatusSegment(stats.numItemsPlanToWatch, Color.parseColor("#9E9E9E"))
        )

        for (segment in segments) {
            if (segment.count <= 0) continue
            val view = View(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    segment.count / total
                )
                setBackgroundColor(segment.color)
            }
            statusBarContainer?.addView(view)
        }
    }

    private fun populatePreferences(user: User) {
        // Content types
        contentTypesChipGroup?.removeAllViews()
        if (user.contentPreferences.isEmpty()) {
            val chip = Chip(requireContext()).apply {
                text = "None set"
                isCheckable = false
            }
            contentTypesChipGroup?.addView(chip)
        } else {
            for (pref in user.contentPreferences) {
                val chip = Chip(requireContext()).apply {
                    text = when (pref) {
                        "anime" -> "Anime"
                        "manga" -> "Manga"
                        "novels" -> "Light Novels"
                        else -> pref.replaceFirstChar { it.uppercase() }
                    }
                    isCheckable = false
                }
                contentTypesChipGroup?.addView(chip)
            }
        }

        // Genres
        genresChipGroup?.removeAllViews()
        if (user.genrePreferences.isEmpty()) {
            val chip = Chip(requireContext()).apply {
                text = "None set"
                isCheckable = false
            }
            genresChipGroup?.addView(chip)
        } else {
            for (genre in user.genrePreferences) {
                val chip = Chip(requireContext()).apply {
                    text = genre
                    isCheckable = false
                }
                genresChipGroup?.addView(chip)
            }
        }
    }
}
