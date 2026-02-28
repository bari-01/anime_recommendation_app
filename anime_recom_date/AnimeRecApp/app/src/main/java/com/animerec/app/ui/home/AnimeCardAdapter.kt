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
package com.animerec.app.ui.home

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
import com.animerec.app.models.ContentType
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

/**
 * Adapter for anime/manga card items in the swipe stack.
 */
class AnimeCardAdapter(private val context: Context) : 
    ListAdapter<AnimeContent, AnimeCardAdapter.AnimeCardViewHolder>(AnimeContentDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anime_card, parent, false)
        return AnimeCardViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: AnimeCardViewHolder, position: Int) {
        val content = getItem(position)
        holder.bind(content)
    }
    
    inner class AnimeCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val coverImageView: ImageView = itemView.findViewById(R.id.anime_image)
        private val titleTextView: TextView = itemView.findViewById(R.id.anime_title)
        private val genresTextView: TextView = itemView.findViewById(R.id.anime_genres)
        private val ratingTextView: TextView = itemView.findViewById(R.id.anime_rating)
        private val typeTextView: TextView = itemView.findViewById(R.id.anime_type)
        private val episodesTextView: TextView = itemView.findViewById(R.id.anime_episodes)
        
        fun bind(content: AnimeContent) {
            // Set title
            titleTextView.text = content.title
            
            // Set genres
            genresTextView.text = content.genres.joinToString(", ")
            
            // Set rating
            if (content.malScore > 0) {
                ratingTextView.text = String.format("%.1f", content.malScore)
                ratingTextView.visibility = View.VISIBLE
            } else {
                ratingTextView.visibility = View.GONE
            }
            
            // Set type
            typeTextView.text = when (content.type) {
                ContentType.ANIME -> content.mediaType.ifEmpty { "TV" }
                ContentType.MANGA -> "Manga"
                ContentType.NOVEL -> "Novel"
            }
            
            // Set episodes/chapters
            episodesTextView.text = when (content.type) {
                ContentType.ANIME -> content.episodes?.let { "$it eps" } ?: ""
                ContentType.MANGA -> content.chapters?.let { "$it ch" } ?: ""
                ContentType.NOVEL -> content.volumes?.let { "$it vol" } ?: ""
            }
            
            // Load image with Glide
            if (content.imageUrl.isNotEmpty()) {
                val requestOptions = RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                
                Glide.with(context)
                    .load(content.imageUrl)
                    .apply(requestOptions)
                    .transition(DrawableTransitionOptions.withCrossFade(300))
                    .into(coverImageView)
            } else {
                coverImageView.setImageResource(R.drawable.gradient_bottom)
            }
        }
    }
    
    /**
     * DiffUtil for efficient updates.
     */
    class AnimeContentDiffCallback : DiffUtil.ItemCallback<AnimeContent>() {
        override fun areItemsTheSame(oldItem: AnimeContent, newItem: AnimeContent): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: AnimeContent, newItem: AnimeContent): Boolean {
            return oldItem == newItem
        }
    }
    
    override fun onViewRecycled(holder: AnimeCardViewHolder) {
        super.onViewRecycled(holder)
        // Clear the image when the view is recycled
        Glide.with(context).clear(holder.itemView.findViewById<ImageView>(R.id.anime_image))
    }
}