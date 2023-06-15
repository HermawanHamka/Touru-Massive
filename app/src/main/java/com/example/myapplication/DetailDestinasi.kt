package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class DetailDestinasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_destinasi)
        Glide.with(this)
            .load(intent.getStringExtra("intent_image"))


            .placeholder(R.drawable.grey_background)
            .error(R.drawable.grey_background)
            .into(findViewById(R.id.img_item_fotodestinasi))

        val nameDestinasi = findViewById<TextView>(R.id.tv_item_nama_destinasi)
        nameDestinasi.text = intent.getStringExtra("intent_title")
//        val destinasi = intent.getParcelableExtra<HeroDestinasi>(DestinasiFragment.INTENT_PARCELABLE)
//
//        val imgDestinasi = findViewById<ImageView>(R.id.img_item_fotodestinasi)
//        val nameDestinasi = findViewById<TextView>(R.id.tv_item_nama_destinasi)
//        val deskripsiDestinasi = findViewById<TextView>(R.id.tv_item_deskripsi_destinasi)
//
//
//        imgDestinasi.setImageResource(destinasi?.imgDestinasi!!)
//        nameDestinasi.text = destinasi.namaDestinasi
//        deskripsiDestinasi.text = destinasi.deskripsiDestinasi
//
        val backButton: ImageButton = findViewById<ImageButton>(R.id.tombol_kembali)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
    }
}
}
