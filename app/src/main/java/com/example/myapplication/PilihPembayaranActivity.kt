package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PilihPembayaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_pembayaran)

        val backButton: ImageView = findViewById<ImageView>(R.id.imgBackPilihPembayaran)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        val btnLanjut = findViewById<Button>(R.id.btnLanjut)
        btnLanjut.setOnClickListener {
            val pindahPembayaran = Intent(this, Pembayaran2Activity::class.java)
            startActivity(pindahPembayaran)
        }
    }
}