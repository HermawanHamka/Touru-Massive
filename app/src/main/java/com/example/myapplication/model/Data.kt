package com.example.myapplication.model


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Data(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("_id")
    val id: String? = "",
//    @SerializedName("ktp")
//    val ktp: String? = "",
    @SerializedName("nohp")
    val nohp: String? = "",
    @SerializedName("password")
    val password: String? = "",
    @SerializedName("tgllahir")
    val tgllahir: String? = "",
    @SerializedName("updatedAt")
    val updatedAt: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("__v")
    val v: Int? = 0
) : Parcelable


@Keep
@Parcelize
data class DataDestination(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("desc")
    val desc: String? = "",
    @SerializedName("_id")
    val id: String? = "",
    @SerializedName("inter_price")
    val inter_Price: Int? = 0,
    @SerializedName("local_price")
    val local_Price: Int? = 0,
    @SerializedName("photo")
    val photo: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("updatedAt")
    val updatedAt: String? = "",
    @SerializedName("__v")
    val v: Int? = 0
) : Parcelable

@Keep
@Parcelize
data class DataTourguide(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("desc")
    val desc: String? = "",
    @SerializedName("deskripsi")
    val deskripsi: String? = "",
    @SerializedName("featured")
    val featured: Boolean? = false,
    @SerializedName("_id")
    val id: String? = "",
    @SerializedName("language")
    val language: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("photo")
    val photo_tour: String? = "",
    @SerializedName("price")
    val price: Int? = 0,
    @SerializedName("reviews")
    val reviews: List<DataTourguide> = listOf(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("updatedAt")
    val updatedAt: String? = "",
    @SerializedName("__v")
    val v: Int? = 0
) : Parcelable

@Keep
@Parcelize
data class DataHomestay(
    @SerializedName("address")
    val address: String? = "",
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("desc")
    val desc: String? = "",
    @SerializedName("distance")
    val distance: Int? = 0,
    @SerializedName("featured")
    val featured: Boolean? = false,
    @SerializedName("_id")
    val id: String? = "",
    @SerializedName("judul")
    val judul: String? = "",
    @SerializedName("maxGroupSize")
    val maxGroupSize: Int? = 0,
    @SerializedName("photo")
    val photo_homestay : String? = "",
    @SerializedName("price")
    val price_homestay: Int? = 0,
    @SerializedName("reviews")
    val reviews: List<Review?>? = listOf(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("updatedAt")
    val updatedAt: String? = "",
    @SerializedName("__v")
    val v: Int? = 0
) : Parcelable
