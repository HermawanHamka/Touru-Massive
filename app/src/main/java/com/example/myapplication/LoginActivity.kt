package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.TextView
import com.example.myapplication.fragment_menu.HomeFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        /* get id */
        val lupaSandi  = findViewById<TextView>(R.id.lupaKataSandiLogin)
        val daftar  = findViewById<TextView>(R.id.textDaftarLogin)
        val login = findViewById<Button>(R.id.btnMasukHome)



        //pindah activity
        lupaSandi.setOnClickListener {
            val pindahLogin = Intent(this, LupaPassActivity::class.java)
            startActivity(pindahLogin)
        }
        daftar.setOnClickListener {
            val pindahDaftar = Intent(this, RegisterActivity::class.java)
            startActivity(pindahDaftar)
        }
        login.setOnClickListener {
            val pindahHome = Intent(this, HomeFragment::class.java)
            startActivity(pindahHome)
        }
    }
}