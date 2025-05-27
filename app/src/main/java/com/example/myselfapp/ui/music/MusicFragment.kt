package com.example.myselfapp.ui.music

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myselfapp.R
import com.example.myselfapp.adapter.MusicAdapter
import com.example.myselfapp.data.Data
import com.example.myselfapp.data.Music
import com.example.myselfapp.data.Video
import com.example.myselfapp.databinding.FragmentMusicBinding

class MusicFragment : Fragment(), MusicAdapter.MusicInteractionListener {

    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    private lateinit var musicAdapter: MusicAdapter
    private lateinit var videoAdapter: VideoAdapter

    private lateinit var musicList : List<Music>
    private lateinit var videoList : List<Video>

    private var mediaPlayer: MediaPlayer? = null
    private var currentPlayingMusicResId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediaPlayer = MediaPlayer()

        setupRvMusic()
        setupRvVideo()
    }

    private fun setupRvMusic() {
        musicList = Data.dataMusic

        musicAdapter = MusicAdapter(musicList, this)
        binding.rvMusic.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = musicAdapter
        }
    }

    private fun setupRvVideo() {
        videoList = Data.dataVideo

        videoAdapter = VideoAdapter(videoList, viewLifecycleOwner.lifecycle)
        binding.rvVideo.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = videoAdapter
        }
    }

    override fun onMusicClick(musicResourceId: Int) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer()
        }

        try {
            if (currentPlayingMusicResId == musicResourceId) { // Lagu yang sama diklik
                if (mediaPlayer!!.isPlaying) {
                    mediaPlayer!!.pause()
                    musicAdapter.updatePlaybackState(musicResourceId, false)
                } else {
                    mediaPlayer!!.start()
                    musicAdapter.updatePlaybackState(musicResourceId, true)
                }
            } else {
                mediaPlayer!!.reset()
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/$musicResourceId")
                mediaPlayer!!.setDataSource(requireContext(), uri)
                mediaPlayer!!.prepare()
                mediaPlayer!!.start()
                musicAdapter.updatePlaybackState(musicResourceId, true)
                currentPlayingMusicResId = musicResourceId
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Error memutar musik: ${e.message}", Toast.LENGTH_SHORT).show()
            musicAdapter.updatePlaybackState(currentPlayingMusicResId, false)
            currentPlayingMusicResId = null
        }
        mediaPlayer?.setOnCompletionListener {
            musicAdapter.updatePlaybackState(currentPlayingMusicResId, false)
            currentPlayingMusicResId = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        if (::musicAdapter.isInitialized) {
            binding.rvMusic.adapter = null
        }
        if (::videoAdapter.isInitialized) {
            binding.rvVideo.adapter = null
        }
        _binding = null
    }

}