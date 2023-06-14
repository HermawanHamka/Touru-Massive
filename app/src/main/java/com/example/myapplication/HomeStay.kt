package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.HomeStayAdapter

class HomeStay : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<HeroHomestay>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_stay)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
        val backButton: ImageView = findViewById<ImageView>(R.id.kembali)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }



    private fun getListHeroes(): ArrayList<HeroHomestay> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataHarga = resources.getStringArray(R.array.data_harga)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataRating = resources.getStringArray(R.array.data_rating)
        val detailProduk = resources.getStringArray(R.array.data_detail)
        val listHeroHomestays = ArrayList<HeroHomestay>()
        for (i in dataName.indices) {
            val heroHomestay = HeroHomestay(dataName[i], dataHarga[i], dataPhoto.getResourceId(i, -1), dataRating[i], detailProduk[i])
            listHeroHomestays.add(heroHomestay)
        }
        return listHeroHomestays
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val HomeStayAdapter = HomeStayAdapter(list)
        rvHeroes.adapter = HomeStayAdapter
        HomeStayAdapter.setOnItemClickCallback(object : HomeStayAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HeroHomestay) {
                showSelectedHero(data)
                val DataIntent = Intent(this@HomeStay, DetailHomeStay::class.java)
                DataIntent.putExtra(DetailHomeStay.EXTRA_IMAGE, data.photo)
                DataIntent.putExtra(DetailHomeStay.EXTRA_NAME, data.name)
                DataIntent.putExtra(DetailHomeStay.EXTRA_HARGA, data.harga)
                DataIntent.putExtra(DetailHomeStay.EXTRA_DETAIL, data.detail)
                DataIntent.putExtra(DetailHomeStay.EXTRA_RATING, data.ratingg)
                startActivity(DataIntent)

            }
        })
    }

    private fun showSelectedHero(heroHomestay: HeroHomestay) {
        Toast.makeText(this, "Kamu memilih " + heroHomestay.name, Toast.LENGTH_SHORT).show()
    }


}