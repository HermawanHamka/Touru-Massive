package com.example.myapplication.retrofit

import com.example.myapplication.model.DestinasiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("data.php")
    fun getData(): Call<DestinasiModel>

}