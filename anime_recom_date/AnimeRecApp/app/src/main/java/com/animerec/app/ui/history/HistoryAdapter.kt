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

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.animerec.app.R
import com.animerec.app.models.AnimeContent
import com.animerec.app.models.ContentType
import com.bumptech.glide.Glide

/**
 * Adapter for displaying history items.
 */
class HistoryAdapter(
    private val context: Context,
    private val listener: OnItemClickListener
) : ListAdapter<AnimeContent, HistoryAdapter.HistoryViewHolder>(HistoryDiffCallback()) {
    
    interface OnItemClickListener {
        fun onItemClick(content: AnimeContent)
        fun onRateItem(content: AnimeContent, score: Int)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val content = getItem(position)
        holder.bind(content)
    }
    
    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val coverImageView: ImageView = itemView.findViewById(R.id.coverImageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val typeTextView: TextView = itemView.findViewById(R.id.typeTextView)
        private val statusTextView: TextView = itemView.findViewById(R.id.statusTextView)
        private val malScoreTextView: TextView = itemView.findViewById(R.id.malScoreTextView)
        private val userRatingBar: RatingBar = itemView.findViewById(R.id.userRatingBar)
        
        fun bind(content: AnimeContent) {
            // Set title
            titleTextView.text = content.title
            
            // Set type
            typeTextView.text = when (content.type) {
                ContentType.ANIME -> "Anime"
                ContentType.MANGA -> "Manga"
                ContentType.NOVEL -> "Light Novel"
            }
            
            // Set status
            statusTextView.text = formatStatus(content.status)
            
            // Set MAL score if available
            if (content.malScore > 0) {
                malScoreTextView.text = "MAL: ${String.format("%.1f", content.malScore)}"
                malScoreTextView.visibility = View.VISIBLE
            } else {
                malScoreTextView.visibility = View.GONE
            }
            
            // Set user rating if available
            userRatingBar.rating = content.userScore?.toFloat()?.div(2) ?: 0f
            
            // Set rating change listener
            userRatingBar.setOnRatingBarChangeListener { _, rating, fromUser ->
                if (fromUser) {
                    val score = (rating * 2).toInt()
                    listener.onRateItem(content, score)
                }
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
        }
        
        private fun formatStatus(status: String): String {
            return when (status) {
                "watching" -> "Watching"
                "reading" -> "Reading"
                "completed" -> "Completed"
                "on_hold" -> "On Hold"
                "dropped" -> "Dropped"
                else -> status.replaceFirstChar { it.uppercase() }
            }
        }
    }
    
    class HistoryDiffCallback : DiffUtil.ItemCallback<AnimeContent>() {
        override fun areItemsTheSame(oldItem: AnimeContent, newItem: AnimeContent): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: AnimeContent, newItem: AnimeContent): Boolean {
            return oldItem == newItem
        }
    }
}