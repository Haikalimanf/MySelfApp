package com.example.myselfapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val title: String,
    val url: String,
    val imageUrl: String,
    val creatorName: String
): Parcelable
