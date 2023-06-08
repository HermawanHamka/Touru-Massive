package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R.id.rv_heroes
import com.example.myapplication.adapter.ListHeroAdapter

class TourGuide : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour_guide)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }



    private fun getListHeroes(): ArrayList<Hero> {
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

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
                val DataIntent = Intent(this@TourGuide, DetailTourGuide::class.java)
                DataIntent.putExtra(DetailTourGuide.EXTRA_IMAGE, data.photo)
                DataIntent.putExtra(DetailTourGuide.EXTRA_NAME, data.name)
                DataIntent.putExtra(DetailTourGuide.EXTRA_HARGA, data.harga)
                DataIntent.putExtra(DetailTourGuide.EXTRA_DETAIL, data.detail)
                DataIntent.putExtra(DetailTourGuide.EXTRA_RATING, data.ratingg)
                startActivity(DataIntent)

            }
        })
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }


}