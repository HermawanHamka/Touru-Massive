package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by sidiqpermana on 10/29/16.
 */

@Parcelize
data class HeroTourguide(
    val name: String,
    val harga: String,
    val photo: Int,
    val ratingg: String,
    val detail : String
) : Parcelable
