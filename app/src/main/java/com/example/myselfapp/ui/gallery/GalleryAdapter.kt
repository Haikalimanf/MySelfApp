package com.example.myselfapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myselfapp.data.Gallery
import com.example.myselfapp.databinding.ItemLayoutGalleryBinding

class GalleryAdapter(private val galleryList: List<Gallery>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {
    inner class GalleryViewHolder(val binding: ItemLayoutGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gallery: Gallery) {
            Glide.with(binding.root.context)
                .load(gallery.imageUrl)
                .into(binding.imgGallery)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val binding = ItemLayoutGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryViewHolder(binding)
    }

    override fun getItemCount(): Int = galleryList.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(galleryList[position])
    }
}