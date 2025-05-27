// File: com/example/myselfapp/adapter/MusicAdapter.kt
package com.example.myselfapp.adapter // Atau package Anda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myselfapp.R
import com.example.myselfapp.data.Music
import com.example.myselfapp.databinding.ItemLayoutMusicBinding

class MusicAdapter(
    private val musicList: List<Music>,
    private val listener: MusicInteractionListener
) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    var currentPlayingMusicId: Int? = null
    var isCurrentlyPlaying: Boolean = false

    class MusicViewHolder(val binding: ItemLayoutMusicBinding) : RecyclerView.ViewHolder(binding.root)

    interface MusicInteractionListener {
        fun onMusicClick(musicResourceId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = ItemLayoutMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    override fun getItemCount(): Int = musicList.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val musicItem = musicList[position]
        holder.binding.txtTitleMusic.text = musicItem.name

        Glide.with(holder.binding.root.context)
            .load(musicItem.imageUrl)
            .into(holder.binding.imgMusic)

        val isThisTrackCurrentlyPlaying = musicItem.url == currentPlayingMusicId && isCurrentlyPlaying


        holder.binding.btnPlayPause.setImageResource(
            if (isThisTrackCurrentlyPlaying) R.drawable.ic_music_pause else R.drawable.ic_music_play_arrow
        )

        holder.binding.root.setOnClickListener {
            listener.onMusicClick(musicItem.url)
        }
    }

    fun updatePlaybackState(playingId: Int?, isPlayingNew: Boolean) {
        val previousPlayingId = currentPlayingMusicId
        currentPlayingMusicId = playingId
        isCurrentlyPlaying = isPlayingNew

        if (previousPlayingId != null) {
            val oldPosition = musicList.indexOfFirst { it.url == previousPlayingId }
            if (oldPosition != -1) notifyItemChanged(oldPosition)
        }
        if (playingId != null) {
            val newPosition = musicList.indexOfFirst { it.url == playingId }
            if (newPosition != -1) notifyItemChanged(newPosition)
        }
        if (playingId == null && previousPlayingId != null && !isPlayingNew) {
            val oldPosition = musicList.indexOfFirst { it.url == previousPlayingId }
            if (oldPosition != -1) notifyItemChanged(oldPosition)
        }
    }
}