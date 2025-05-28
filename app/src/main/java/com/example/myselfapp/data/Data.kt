package com.example.myselfapp.data

import com.example.myselfapp.R

object Data {

    val dataDaily = listOf(
        Daily(
            title = "GYM",
            image = R.drawable.jogging
        ),
        Daily(
            title = "Mengoding",
            image = R.drawable.mengoding
        ),
        Daily(
            title = "Makan",
            image = R.drawable.eat
        )

    )

    val dataFriend = listOf(
        Friend(
            name = "Arik Hikari Hidayatullah",
            image = R.drawable.arik
        ),
        Friend(
            name = "Dewa Tri sakti",
            image = R.drawable.dewa
        ),
        Friend(
            name = "Raditya El Wall",
            image = R.drawable.elwal
        ),
        Friend(
            name = "Pa Ebj Nugraha",
            image = R.drawable.paebj
        ),
    )

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


    val dataGallery = listOf(
        Gallery("https://raw.githubusercontent.com/Haikalimanf/AssetFotoIconSalon/refs/heads/main/photo_2024-11-17_11-27-59.jpg"),
        Gallery("https://raw.githubusercontent.com/Haikalimanf/AssetFotoIconSalon/refs/heads/main/photo_2024-11-17_08-58-06.jpg"),
        Gallery("https://raw.githubusercontent.com/Haikalimanf/AssetFotoIconSalon/refs/heads/main/WhatsApp%20Image%202025-05-04%20at%2021.06.27_1666fef6.jpg"),
        Gallery("https://raw.githubusercontent.com/Haikalimanf/AssetFotoIconSalon/refs/heads/main/SemiFormal.jpg"),
        Gallery("https://raw.githubusercontent.com/Haikalimanf/AssetFotoIconSalon/refs/heads/main/IMG_20240916_061332.jpg"),
        Gallery("https://raw.githubusercontent.com/Haikalimanf/AssetFotoIconSalon/refs/heads/main/Firefly%2020250216154941.png"),
    )

}