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
package com.animerec.app.ui.history

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.animerec.app.R
import com.animerec.app.data.Resource
import com.animerec.app.models.AnimeContent
import com.animerec.app.models.ContentType
import com.google.android.material.tabs.TabLayout

/**
 * Fragment for displaying user's history (completed and dropped items).
 */
class HistoryFragment : Fragment(), HistoryAdapter.OnItemClickListener {

    private val TAG = "HistoryFragment"
    private lateinit var viewModel: HistoryViewModel

    // UI components — nullable to prevent memory leaks after onDestroyView
    private var tabLayout: TabLayout? = null
    private var statusTabLayout: TabLayout? = null
    private var recyclerView: RecyclerView? = null
    private var loadingIndicator: ProgressBar? = null
    private var emptyStateTextView: TextView? = null
    private var adapter: HistoryAdapter? = null

    // Current selections
    private var currentContentType = ContentType.ANIME
    private var currentStatus = "completed"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HistoryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize UI components
        tabLayout = view.findViewById(R.id.contentTypeTabLayout)
        statusTabLayout = view.findViewById(R.id.statusTabLayout)
        recyclerView = view.findViewById(R.id.recyclerView)
        loadingIndicator = view.findViewById(R.id.loadingIndicator)
        emptyStateTextView = view.findViewById(R.id.emptyStateTextView)

        // Set up the tab layouts
        setupContentTypeTabs()
        setupStatusTabs()

        // Set up recycler view
        adapter = HistoryAdapter(requireContext(), this)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HistoryFragment.adapter
            setHasFixedSize(true)
        }

        // Observe history data
        viewModel.historyItems.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    showLoading(true)
                    emptyStateTextView?.visibility = View.GONE
                }
                is Resource.Success -> {
                    showLoading(false)

                    if (resource.data.isEmpty()) {
                        showEmptyState(true)
                    } else {
                        showEmptyState(false)
                        adapter?.submitList(resource.data)
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    showEmptyState(true, resource.message)
                    Log.e(TAG, "Error loading history: ${resource.message}")
                }
            }
        }

        // Load initial data
        loadHistory(currentContentType, currentStatus)
    }

    private fun setupContentTypeTabs() {
        tabLayout?.let { tl ->
            // Add tabs for different content types
            tl.addTab(tl.newTab().setText("Anime"))
            tl.addTab(tl.newTab().setText("Manga"))
            tl.addTab(tl.newTab().setText("Novels"))

            // Handle tab selection
            tl.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    currentContentType = when (tab.position) {
                        0 -> ContentType.ANIME
                        1 -> ContentType.MANGA
                        2 -> ContentType.NOVEL
                        else -> ContentType.ANIME
                    }
                    loadHistory(currentContentType, currentStatus)
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }
    }

    private fun setupStatusTabs() {
        statusTabLayout?.let { stl ->
            // Add tabs for different statuses
            stl.addTab(stl.newTab().setText("Completed"))
            stl.addTab(stl.newTab().setText("Watching"))
            stl.addTab(stl.newTab().setText("On Hold"))
            stl.addTab(stl.newTab().setText("Dropped"))

            // Handle tab selection
            stl.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    currentStatus = when (tab.position) {
                        0 -> "completed"
                        1 -> if (currentContentType == ContentType.ANIME) "watching" else "reading"
                        2 -> "on_hold"
                        3 -> "dropped"
                        else -> "completed"
                    }
                    loadHistory(currentContentType, currentStatus)
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }
    }

    private fun loadHistory(contentType: ContentType, status: String) {
        viewModel.loadHistory(contentType, status)
    }

    private fun showLoading(isLoading: Boolean) {
        loadingIndicator?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showEmptyState(isEmpty: Boolean, errorMessage: String? = null) {
        if (isEmpty) {
            recyclerView?.visibility = View.GONE
            emptyStateTextView?.visibility = View.VISIBLE

            val statusText = when (currentStatus) {
                "completed" -> "completed"
                "watching", "reading" -> if (currentContentType == ContentType.ANIME) "watching" else "reading"
                "on_hold" -> "on hold"
                "dropped" -> "dropped"
                else -> currentStatus
            }

            val typeText = when (currentContentType) {
                ContentType.ANIME -> "anime"
                ContentType.MANGA -> "manga"
                ContentType.NOVEL -> "light novels"
            }

            emptyStateTextView?.text = errorMessage ?:
                "No $statusText $typeText found. Start exploring recommendations to build your list!"
        } else {
            recyclerView?.visibility = View.VISIBLE
            emptyStateTextView?.visibility = View.GONE
        }
    }

    override fun onItemClick(content: AnimeContent) {
        // Navigate to details screen
        val bundle = Bundle().apply {
            putInt("contentId", content.id)
            putString("contentType", content.type.name)
        }
        findNavController().navigate(R.id.action_historyFragment_to_detailsFragment, bundle)
    }

    override fun onRateItem(content: AnimeContent, score: Int) {
        viewModel.rateContent(content, score)
    }

    override fun onDestroyView() {
        tabLayout = null
        statusTabLayout = null
        recyclerView = null
        loadingIndicator = null
        emptyStateTextView = null
        adapter = null
        super.onDestroyView()
    }
}
