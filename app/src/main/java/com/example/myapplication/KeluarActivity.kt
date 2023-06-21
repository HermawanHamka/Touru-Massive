package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.helper.PreferenceHelper

class KeluarActivity : AppCompatActivity() {

    lateinit var sharedPref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keluar)
        /* get id */
        val btnYes = findViewById<Button>(R.id.btnYes)

        sharedPref = PreferenceHelper(this)

        btnYes.setOnClickListener {
            sharedPref.clear()
            Toast.makeText(applicationContext,"Berhasil Keluar!!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}