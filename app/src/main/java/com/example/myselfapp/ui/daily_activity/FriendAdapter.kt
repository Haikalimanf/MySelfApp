package com.example.myselfapp.ui.daily_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapp.data.Friend
import com.example.myselfapp.databinding.ItemLayoutDailyBinding

class FriendAdapter(private val friendList: List<Friend>) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    class FriendViewHolder(val binding: ItemLayoutDailyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(friend: Friend){
            binding.txtTitle.text = friend.name
            binding.imgDaily.setImageResource(friend.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = ItemLayoutDailyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendViewHolder(binding)
    }

    override fun getItemCount(): Int = friendList.size

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friendList[position])
    }
}