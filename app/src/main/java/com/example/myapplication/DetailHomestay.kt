package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailHomestay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_homestay)
        Glide.with(this)
            .load(intent.getStringExtra("photo_homestay"))
            .placeholder(R.drawable.grey_background)
            .error(R.drawable.grey_background)
            .into(findViewById(R.id.photoHomestay))

        val namaTourguide = findViewById<TextView>(R.id.nama_homestay)
        namaTourguide.text = intent.getStringExtra("title")

        val lokasiHomestay = findViewById<TextView>(R.id.lokasiH)
        lokasiHomestay .text = intent.getStringExtra("location_homestay")

        val deskripsiHomestay = findViewById<TextView>(R.id.descH)
        deskripsiHomestay.text = intent.getStringExtra("desc_homestay")

        val hargaHomestay = findViewById<TextView>(R.id.hargaH)
        hargaHomestay.text = intent.getStringExtra("price_homestay")

        val btnPesanHomestay = findViewById<Button>(R.id.btnPesanHomestay)
        btnPesanHomestay.setOnClickListener {
            val pindahPesanHomestay = Intent(this, TransaksiActivity::class.java)
            startActivity(pindahPesanHomestay)
        }

        val backButton: ImageButton = findViewById(R.id.tombol_kembali)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}