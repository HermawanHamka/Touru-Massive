package com.example.myapplication.retrofit_loginregister

import com.example.myapplication.model.ResponModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("email")email :String,
        @Field("password")password :String,
        @Field("username")username:String,
        @Field("tgllahir")tgllahir :String,
        @Field("nohp")nohp:String,
//        @Field("ktp")ktp:MultipartBody.Part
    ):Call<ResponModel>


//    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email")email:String,
        @Field("password")password :String
    ):Call<ResponModel>
}