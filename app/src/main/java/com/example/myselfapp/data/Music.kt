package com.example.myselfapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    val name: String,
    val url: Int,
    val imageUrl: String
) : Parcelable
