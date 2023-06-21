package com.example.myapplication.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Keep
@Parcelize
data class ResponModel(
    @SerializedName("data")
    val `data`: Data? = Data(),
    @SerializedName("role")
    val role: String? = "",
    @SerializedName("token")
    val token: String? = ""
) : Parcelable