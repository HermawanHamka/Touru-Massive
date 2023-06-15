package com.example.myapplication.model

data class DestinasiModel ( val result: ArrayList<Result> )
{
    data class Result (val id : Int, val title : String, val image : String)
}

