package com.example.myapplication.retrofit_homestay

import com.example.myapplication.model.HomestayModel
import com.example.myapplication.model.TourguideModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("homestays")
    fun getData(): Call<HomestayModel>
}