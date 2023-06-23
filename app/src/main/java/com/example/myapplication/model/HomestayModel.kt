package com.example.myapplication.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Keep
@Parcelize
data class HomestayModel(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("data")
    val `data`: ArrayList<DataHomestay> = arrayListOf(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("success")
    val success: Boolean? = false
) : Parcelable