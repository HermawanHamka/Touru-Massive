package com.example.myapplication.fragment_menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.DestinasiModel
import com.example.myapplication.DetailDestinasi
import com.example.myapplication.R
import com.example.myapplication.adapter.DestinasiAdapter
import com.example.myapplication.find
import com.example.myapplication.model.DataDestination
import com.example.myapplication.retrofit_destinasi.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinasiFragment : Fragment() {
    private val TAG: String = "DestinasiFragment"
    private  lateinit var destinasiAdapter: DestinasiAdapter
    private lateinit var searchView: SearchView
    private val originalData: ArrayList<DataDestination> = ArrayList()
    private val filteredData: ArrayList<DataDestination> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destinasi, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

    private fun setupRecyclerView() {
        val recyclerView by lazy { find<RecyclerView>(R.id.rv_heroes_destinasi) }
        destinasiAdapter = DestinasiAdapter(originalData, filteredData,object : DestinasiAdapter.OnAdapterListener {
            override fun onClick(results: DataDestination) {
                startActivity(
                    Intent(context, DetailDestinasi::class.java)
                        .putExtra("photo_destinasi", "http://192.168.0.103:3000${results.photo}")
                        .putExtra("title", results.title)
                        .putExtra("desc", results.desc)
                        .putExtra("city", results.city)
                        .putExtra("local_price", results.local_Price.toString())
                        .putExtra("inter_price", results.inter_Price.toString())
                )
            }

        })

        recyclerView.apply {
            recyclerView.layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL, false)
            recyclerView.adapter = destinasiAdapter

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        searchView = view.findViewById(R.id.search_view)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                destinasiAdapter.filterData(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

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
                        if(response.body()!= null) showData(response.body()!!)
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

    fun showData(data: DestinasiModel) {
        val results:ArrayList<DataDestination> = arrayListOf()
        results.addAll(data.data)
        destinasiAdapter.setData(results)
    }
}


