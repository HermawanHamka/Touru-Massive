package com.example.myapplication

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

inline fun <reified T : RecyclerView> Fragment.find(Id:Int): T = view?.findViewById(R.id.rv_heroes) as T
