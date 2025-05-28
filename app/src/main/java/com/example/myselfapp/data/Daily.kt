package com.example.myselfapp.data

import android.graphics.drawable.Icon
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Daily(
    val title: String,
    val image: Int
): Parcelable


