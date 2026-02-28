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
package com.animerec.app.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.animerec.app.R
import com.animerec.app.models.AnimeContent
import com.bumptech.glide.Glide

/**
 * Adapter for displaying similar content items.
 */
class SimilarContentAdapter(
    private val context: Context,
    private val onItemClickListener: (AnimeContent) -> Unit
) : ListAdapter<AnimeContent, SimilarContentAdapter.SimilarContentViewHolder>(SimilarContentDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarContentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_similar_content, parent, false)
        return SimilarContentViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: SimilarContentViewHolder, position: Int) {
        val content = getItem(position)
        holder.bind(content)
    }
    
    inner class SimilarContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val coverImageView: ImageView = itemView.findViewById(R.id.coverImageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val ratingTextView: TextView = itemView.findViewById(R.id.ratingTextView)
        
        fun bind(content: AnimeContent) {
            // Set title
            titleTextView.text = content.title
            
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
                onItemClickListener(content)
            }
        }
    }
    
    class SimilarContentDiffCallback : DiffUtil.ItemCallback<AnimeContent>() {
        override fun areItemsTheSame(oldItem: AnimeContent, newItem: AnimeContent): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: AnimeContent, newItem: AnimeContent): Boolean {
            return oldItem == newItem
        }
    }
}