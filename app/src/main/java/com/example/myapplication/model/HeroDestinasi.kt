package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroDestinasi(
    val imgDestinasi: Int,
    val namaDestinasi: String,
    val deskripsiDestinasi: String,
) : Parcelable
