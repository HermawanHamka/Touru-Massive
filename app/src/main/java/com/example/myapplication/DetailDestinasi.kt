package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailDestinasi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_destinasi)
        Glide.with(this)
            .load(intent.getStringExtra("photo"))
            .placeholder(R.drawable.grey_background)
            .error(R.drawable.grey_background)
            .into(findViewById(R.id.img_item_fotodestinasi))

        val namaDestinasi = findViewById<TextView>(R.id.tv_item_nama_destinasi)
        namaDestinasi.text = intent.getStringExtra("title")

        val kotaDestinasi = findViewById<TextView>(R.id.tv_item_city_destinasi)
        kotaDestinasi.text = intent.getStringExtra("city")

        val deskripsiDestinasi = findViewById<TextView>(R.id.tv_item_deskripsi_destinasi)
        deskripsiDestinasi.text = intent.getStringExtra("desc")

        val hargaLokal = findViewById<TextView>(R.id.tv_localprice)
        hargaLokal.text = intent.getStringExtra("localprice")
        val hargaInter = findViewById<TextView>(R.id.tv_interprice)
        hargaInter.text = intent.getStringExtra("localprice")

        val backButton: ImageButton = findViewById<ImageButton>(R.id.tombol_kembali)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
    }
}
}

