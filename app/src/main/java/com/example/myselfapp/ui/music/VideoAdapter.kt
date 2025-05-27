package com.example.myselfapp.ui.music

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle // Pastikan ini adalah androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapp.data.Video // Asumsi Video class punya 'url', 'title', 'creatorName'
import com.example.myselfapp.databinding.ItemLayoutVideoBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class VideoAdapter(
    private val videoList: List<Video>,
    private val lifecycle: Lifecycle
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(val binding: ItemLayoutVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(video: Video) {
            binding.eventTitle.text = video.title
            binding.eventStatus.text = video.creatorName

            val videoId = extractYoutubeVideoId(video.url)

            lifecycle.addObserver(binding.youtubePlayerView)
            binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    videoId?.let {
                        youTubePlayer.cueVideo(it, 0f)
                    }
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemLayoutVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun getItemCount(): Int = videoList.size

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videoList[position])
    }

    override fun onViewRecycled(holder: VideoViewHolder) {
        super.onViewRecycled(holder)
    }

    private fun extractYoutubeVideoId(url: String): String? {
        val pattern = "^(?:https?://)?(?:www\\.)?(?:youtube\\.com/(?:[^/]+/.+/|(?:v|e(?:mbed)?)|.*[?&]v=)|youtu\\.be/)([\\w-]{11})".toRegex()
        val matchResult = pattern.find(url)
        return matchResult?.groupValues?.get(1)
    }
}