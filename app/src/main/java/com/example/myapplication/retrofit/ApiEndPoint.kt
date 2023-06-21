package com.example.myapplication.retrofit

import com.example.myapplication.model.DestinasiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

<<<<<<< HEAD
    @GET("data.php")
=======
    @GET("Destination")
>>>>>>> 871b5c5 (destinasi dan login)
    fun getData(): Call<DestinasiModel>

}