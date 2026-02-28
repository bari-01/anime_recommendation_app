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
package com.animerec.app.ui.watchlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.animerec.app.AnimeRecApp
import com.animerec.app.R
import com.animerec.app.models.AnimeContent
import com.animerec.app.models.ContentType
import com.bumptech.glide.Glide

/**
 * Adapter for displaying watchlist items.
 */
class WatchlistAdapter(
    private val context: Context,
    private val listener: OnItemClickListener
) : ListAdapter<AnimeContent, WatchlistAdapter.WatchlistViewHolder>(WatchlistDiffCallback()) {
    
    interface OnItemClickListener {
        fun onItemClick(content: AnimeContent)
        fun onStatusChange(content: AnimeContent, newStatus: String)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_watchlist, parent, false)
        return WatchlistViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: WatchlistViewHolder, position: Int) {
        val content = getItem(position)
        holder.bind(content)
    }
    
    inner class WatchlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val coverImageView: ImageView = itemView.findViewById(R.id.coverImageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val typeAndStatusTextView: TextView = itemView.findViewById(R.id.typeAndStatusTextView)
        private val ratingTextView: TextView = itemView.findViewById(R.id.ratingTextView)
        private val moreOptionsButton: ImageView = itemView.findViewById(R.id.moreOptionsButton)
        
        fun bind(content: AnimeContent) {
            // Set title
            titleTextView.text = content.title
            
            // Set type and status
            val typeText = when (content.type) {
                ContentType.ANIME -> "Anime"
                ContentType.MANGA -> "Manga"
                ContentType.NOVEL -> "Light Novel"
            }
            typeAndStatusTextView.text = "$typeText • ${formatStatus(content.status)}"
            
            // Set rating if available
            if (content.malScore > 0) {
                ratingTextView.text = "★ ${String.format("%.1f", content.malScore)}"
                ratingTextView.visibility = View.VISIBLE
            } else {
                ratingTextView.visibility = View.GONE
            }
            
            // Load cover image
            if (content.imageUrl.isNotEmpty()) {
                Glide.with(context)
                    .load(content.imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.gradient_overlay)
                    .into(coverImageView)
            }
            
            // Set click listener
            itemView.setOnClickListener {
                listener.onItemClick(content)
            }
            
            // Set up more options menu
            moreOptionsButton.setOnClickListener { view ->
                showPopupMenu(view, content)
            }
        }
        
        private fun showPopupMenu(view: View, content: AnimeContent) {
            val popup = PopupMenu(context, view)
            popup.menuInflater.inflate(R.menu.watchlist_item_menu, popup.menu)
            
            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_mark_watching -> {
                        val status = if (content.type == ContentType.ANIME) {
                            "watching"
                        } else {
                            "reading"
                        }
                        listener.onStatusChange(content, status)
                        true
                    }
                    R.id.action_mark_completed -> {
                        listener.onStatusChange(content, "completed")
                        true
                    }
                    R.id.action_mark_on_hold -> {
                        listener.onStatusChange(content, "on_hold")
                        true
                    }
                    R.id.action_mark_dropped -> {
                        listener.onStatusChange(content, "dropped")
                        true
                    }
                    else -> false
                }
            }
            
            popup.show()
        }
        
        private fun formatStatus(status: String): String {
            return when (status) {
                "plan_to_watch" -> "Plan to Watch"
                "plan_to_read" -> "Plan to Read"
                "watching" -> "Watching"
                "reading" -> "Reading"
                "completed" -> "Completed"
                "on_hold" -> "On Hold"
                "dropped" -> "Dropped"
                else -> status.replaceFirstChar { it.uppercase() }
            }
        }
    }
    
    class WatchlistDiffCallback : DiffUtil.ItemCallback<AnimeContent>() {
        override fun areItemsTheSame(oldItem: AnimeContent, newItem: AnimeContent): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: AnimeContent, newItem: AnimeContent): Boolean {
            return oldItem == newItem
        }
    }
}