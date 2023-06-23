package com.example.myapplication.retrofit_tourguide

import com.example.myapplication.model.DestinasiModel
import com.example.myapplication.model.TourguideModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("tourguide")
    fun getData(): Call<TourguideModel>

}