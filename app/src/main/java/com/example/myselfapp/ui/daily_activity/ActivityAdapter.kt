package com.example.myselfapp.ui.daily_activity

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myselfapp.data.Daily
import com.example.myselfapp.databinding.ItemLayoutDailyBinding

class ActivityAdapter(private val activityList: List<Daily>) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {
    class ActivityViewHolder(val binding: ItemLayoutDailyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(daily: Daily){
            binding.txtTitle.text = daily.title
            Glide.with(binding.root.context)
                .load(daily.image)
                .into(binding.imgDaily)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemLayoutDailyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActivityViewHolder(binding)
    }

    override fun getItemCount(): Int = activityList.size

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activityList[position])
    }
}