package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class LupaPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_pass)
        /* get id */
        val backLupaPass  = findViewById<ImageButton>(R.id.imgBacklupaPass)

        //pindah activity
        backLupaPass.setOnClickListener {
            val pindahLogin = Intent(this, LoginActivity::class.java)
            startActivity(pindahLogin)
        }
    }
}