package com.example.myselfapp.data

import com.example.myselfapp.R

object Data {

    val dataVideo = listOf(
        Video(
            title = "TUTORIAL ANDROID DASAR (BAHASA INDONESIA)",
            url = "https://youtu.be/pUTz5IOkBtE?si=eulq5Bdl1oSCFyr2",
            imageUrl = "",
            creatorName = "Programmer Zaman Now"
        ),
        Video(
            title = "Flutter Tutorial | Flutter Fundamentals | Belajar Flutter | Flutter Indonesia - Opening",
            url = "https://youtu.be/SoX3cel4LRM?si=rQxAqZc-YM3YlVr3",
            imageUrl = "",
            creatorName = "Erico Darmawan Handoyo"
        )
    )

    val dataMusic = listOf(
        Music(
            name = "Giorno Giovanno - Angin Emas",
            imageUrl = "https://i.ytimg.com/vi/hqDP482JeXc/hqdefault.jpg",
            url = R.raw.angin_emas
        ),
        Music(
            name = "The 1975 - About You",
            imageUrl = "https://i.ytimg.com/vi/tGv7CUutzqU/hqdefault.jpg",
            url = R.raw.about_you
        )

    )

}