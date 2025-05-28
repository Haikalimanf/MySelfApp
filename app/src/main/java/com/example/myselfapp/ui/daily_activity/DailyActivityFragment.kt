package com.example.myselfapp.ui.daily_activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myselfapp.data.Daily
import com.example.myselfapp.data.Data
import com.example.myselfapp.data.Friend
import com.example.myselfapp.databinding.FragmentDailyActivityBinding

class DailyActivityFragment : Fragment() {

    private var _binding: FragmentDailyActivityBinding? = null
    private val binding get() = _binding!!

    private lateinit var dailyList: List<Daily>
    private lateinit var dailyAdapter: ActivityAdapter

    private lateinit var friendList: List<Friend>
    private lateinit var friendAdapter: FriendAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDailyActivityBinding.inflate(layoutInflater)
        val root: View = binding.root

        setupRvGallery()
        setupRvFriend()

        return root
    }

    private fun setupRvGallery() {
        dailyList = Data.dataDaily

        dailyAdapter = ActivityAdapter(dailyList)
        binding.rvDailyActivity.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = dailyAdapter
        }
    }

    private fun setupRvFriend() {
        friendList = Data.dataFriend

        friendAdapter = FriendAdapter(friendList)
        binding.rvFriend.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = friendAdapter
        }
    }

}