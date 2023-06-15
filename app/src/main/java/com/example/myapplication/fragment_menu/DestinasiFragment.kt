package com.example.myapplication.fragment_menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.DestinasiModel
import com.example.myapplication.DetailDestinasi
import com.example.myapplication.R
import com.example.myapplication.adapter.DestinasiAdapter
import com.example.myapplication.find
import com.example.myapplication.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinasiFragment : Fragment() {
    private val TAG: String = "DestinasiFragment"
    lateinit var destinasiAdapter: DestinasiAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destinasi, container, false)


    }

    private fun setupRecyclerView() {
        val recyclerView by lazy { find<RecyclerView>(R.id.rv_heroes) }
        destinasiAdapter = DestinasiAdapter(arrayListOf(), object : DestinasiAdapter.OnAdapterListener {
            override fun onClick(results: DestinasiModel.Result) {
                startActivity(
                    Intent(activity, DetailDestinasi::class.java)
                        .putExtra("intent_image", results.image)
                        .putExtra("intent_title", results.title)
                )
            }

        })
        recyclerView.apply {
            recyclerView.layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL, false)
            recyclerView.adapter = destinasiAdapter

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()


    }
    private fun getDataFromApi() {
        val progressBar = view?.findViewById<ProgressBar>(R.id.progressBar)
        progressBar!!.visibility = View.VISIBLE
        ApiService.endPoint.getData()
            .enqueue(object : Callback<DestinasiModel>{
                override fun onResponse(
                    call: Call<DestinasiModel>,
                    response: Response<DestinasiModel>)
                {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        showData(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<DestinasiModel>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    printLog("on Failure : $t")
                }

            })

    }
    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showData(data: DestinasiModel) {
        val results = data.result
        destinasiAdapter.setData(results)
    }
}


