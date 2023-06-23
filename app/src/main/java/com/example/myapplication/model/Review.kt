package com.example.myapplication.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Keep
@Parcelize
data class Review(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("_id")
    val id: String? = "",
    @SerializedName("rating")
    val rating: Double? = 0.0,
    @SerializedName("reviewText")
    val reviewText: String? = "",
    @SerializedName("updatedAt")
    val updatedAt: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("__v")
    val v: Int? = 0
) : Parcelable