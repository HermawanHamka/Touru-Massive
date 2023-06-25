package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailTourguide : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tour_guide)
        Glide.with(this)
            .load(intent.getStringExtra("photo_tour"))
            .placeholder(R.drawable.grey_background)
            .error(R.drawable.grey_background)
            .into(findViewById(R.id.photoTourguide))

        val namaTourguide = findViewById<TextView>(R.id.name_tour)
        namaTourguide.text = intent.getStringExtra("name_tour")

        val lokasiTourguide = findViewById<TextView>(R.id.lokasiTour)
        lokasiTourguide.text = intent.getStringExtra("location_tour")

        val hargaTourguide = findViewById<TextView>(R.id.priceTour)
        hargaTourguide.text = intent.getStringExtra("price_tour")

        val deskripsiTourguide = findViewById<TextView>(R.id.descTour)
        deskripsiTourguide.text = intent.getStringExtra("desc_tour")

        val btnPesanTourguide:Button = findViewById(R.id.btnPesanTG)
        btnPesanTourguide.setOnClickListener {
            val pindahTransaksiTG = Intent(this, TransaksiActivity::class.java)
            startActivity(pindahTransaksiTG)
        }

        val backButton: ImageButton = findViewById(R.id.imgBackBantuan)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
