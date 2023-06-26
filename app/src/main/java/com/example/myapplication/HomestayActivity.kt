package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.HomestayAdapter
import com.example.myapplication.model.DataHomestay
import com.example.myapplication.model.HomestayModel
import com.example.myapplication.retrofit_homestay.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomestayActivity : AppCompatActivity() {
    private val TAG: String = "HomestayActivity"

    private lateinit var homestayAdapter: HomestayAdapter
    private lateinit var searchView: SearchView
    private val originalData: ArrayList<DataHomestay> = ArrayList()
    private val filteredData: ArrayList<DataHomestay> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_stay)

        searchView = findViewById(R.id.search_view)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                homestayAdapter.filterData(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                homestayAdapter.filterData(newText ?: "")
                return true
            }
        })
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.rv_heroes_homestay)
        homestayAdapter = HomestayAdapter(originalData, filteredData, object : HomestayAdapter.OnAdapterListener {
            override fun onClick(results: DataHomestay) {
                startActivity(
                    Intent(applicationContext, DetailHomestay::class.java)
                        .putExtra("title", results.title)
                        .putExtra("location_homestay", results.city)
                        .putExtra("desc_homestay", results.desc)
                        .putExtra("price_homestay", results.price_homestay.toString())
                        .putExtra("photo_homestay", "http://192.168.100.7:3000${results.photo_homestay}")
                )
            }
        })

        val backButton: ImageButton = findViewById(R.id.kembaliH)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = homestayAdapter
        }
    }

    private fun getDataFromApi() {
        val progressBar: ProgressBar = findViewById(R.id.progressBar3)
        progressBar.visibility = View.VISIBLE
        ApiService.endPoint.getData()
            .enqueue(object : Callback<HomestayModel> {
                override fun onResponse(call: Call<HomestayModel>, response: Response<HomestayModel>) {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
//                        response.body()?.let { showData(it) }
                        if(response.body()!= null) showData(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<HomestayModel>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    printLog("on Failure : $t")
                }
            })
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showData(data: HomestayModel) {
        originalData.clear()
        originalData.addAll(data.data)
        homestayAdapter.setData(originalData)
    }
}
