package com.example.myapplication.helper

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.LoginActivity
import com.example.myapplication.fragment_menu.ProfileFragment

class PreferenceHelper(context: Context) {

    private val PREF_NAME = "sharedPreference123"
    val sharedPref : SharedPreferences
    val editor : SharedPreferences.Editor
    val login = "login"

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String, value: String){
        editor.putString(key,value)
            .apply()
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String) : Boolean{
        return sharedPref.getBoolean(key, false)
    }

    fun clear(){
        editor.clear()
            .apply()
    }

    fun getString(key: String): String{
        return sharedPref.getString(key,"")!!
    }

//    fun setString(key: String?){
//        sharedPref.edit().putString(login,key).apply()
//    }

    fun setString(key: String?, value: String) {
        sharedPref.edit().putString(key, value).apply()
    }
}