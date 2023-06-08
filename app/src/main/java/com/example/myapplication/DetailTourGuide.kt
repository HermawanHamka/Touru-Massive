package com.example.myapplication

import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailTourGuide : AppCompatActivity() {

    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_HARGA = "extra_harga"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_RATING = "extra_rating"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tour_guide)

        fun getListHeroes(): ArrayList<Hero> {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataHarga = resources.getStringArray(R.array.data_harga)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val dataRating = resources.getStringArray(R.array.data_rating)
            val detailProduk = resources.getStringArray(R.array.data_detail)
            val listHero = ArrayList<Hero>()
            for (i in dataName.indices) {
                val hero = Hero(dataName[i], dataHarga[i], dataPhoto.getResourceId(i, -1), dataRating[i], detailProduk[i])
                listHero.add(hero)
            }
            return listHero
        }
        val tvItemName: TextView = findViewById(R.id.nama_tour)
        val tvItemRating: TextView = findViewById(R.id.rating)
        val ivItemPhoto: ImageView = findViewById(R.id.pp)
        val tvItemDetailDesc: TextView = findViewById(R.id.detailtour)

        val name = intent.getStringExtra(EXTRA_NAME)
        val harga = intent.getStringExtra(EXTRA_HARGA)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val photo = intent.getIntExtra(EXTRA_IMAGE, 0)
        val rating = intent.getStringExtra(EXTRA_RATING)

        tvItemName.text = name
        tvItemRating.text = rating
        tvItemDetailDesc.text = detail



        Glide.with(this@DetailTourGuide)
            .load(photo)
            .into(ivItemPhoto)
    }
    }
