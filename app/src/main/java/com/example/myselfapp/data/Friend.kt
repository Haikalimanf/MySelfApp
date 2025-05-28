package com.example.myselfapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Friend(
    val name: String,
    val image: Int,
): Parcelable