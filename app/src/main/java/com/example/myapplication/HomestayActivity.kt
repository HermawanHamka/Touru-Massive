package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
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
    val TAG : String = "HomestayActivity"

    private lateinit var homestayAdapter: HomestayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_stay)
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()

    }

    private fun setupRecyclerView() {
        val recyclerView by lazy { findViewById<RecyclerView>(R.id.rv_heroes_homestay) }
        homestayAdapter = HomestayAdapter(arrayListOf(), object : HomestayAdapter.OnAdapterListener{
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

        val backButton: ImageButton = findViewById<ImageButton>(R.id.kembaliH)
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


    fun getDataFromApi() {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar3)
        progressBar!!.visibility = View.VISIBLE
        ApiService.endPoint.getData()
            .enqueue(object : Callback<HomestayModel>{
                override fun onResponse(
                    call: Call<HomestayModel>,
                    response: Response<HomestayModel>
                )
                {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        if(response.body()!= null) showData(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<HomestayModel>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    printLog("on Failure : $t")
                }

            })
    }

    fun printLog(message: String) {
        Log.d(TAG, message)
    }

    fun showData(data: HomestayModel) {
        val results: ArrayList<DataHomestay> = arrayListOf()
        results.addAll(data.data)
        homestayAdapter.setData(results)
    }
}
