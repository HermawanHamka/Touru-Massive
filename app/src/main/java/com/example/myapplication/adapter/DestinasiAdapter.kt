package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.DataDestination
import java.util.*
import kotlin.collections.ArrayList

class DestinasiAdapter
    (private var originalData: ArrayList<DataDestination>,
     private var filteredData: ArrayList<DataDestination>,
     private val listener: OnAdapterListener

     ) : RecyclerView.Adapter<DestinasiAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_destinasi, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filteredData.size
    }

    override fun onBindViewHolder(holder: DestinasiAdapter.ViewHolder, position: Int) {
        val result = filteredData[position]
        holder.bind(result)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val namaDestinasi: TextView = itemView.findViewById(R.id.namaDestinasi)
        private val gambarDestinasi: ImageView = itemView.findViewById(R.id.gambarDestinasi)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val result = filteredData[position]
                    listener.onClick(result)
                }
            }
        }


        fun bind(data: DataDestination) {
            namaDestinasi.text = data.title
            val url = "http://192.168.100.7:3000${data.photo}"
            Glide.with(itemView)
                .load(url)
                .placeholder(R.drawable.grey_background)
                .error(R.drawable.grey_background)
                .centerCrop()
                .into(gambarDestinasi)
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<DataDestination>) {
        originalData = data
        filterData("") // Apply initial filtering
    }
    fun filterData(query: String) {
        filteredData.clear()
        if (query.isEmpty()) {
            filteredData.addAll(originalData) // Show all data if query is empty
        } else {
            val searchQuery = query.lowercase(Locale.getDefault())
            for (item in originalData) {
                if (item.title?.lowercase(Locale.getDefault())?.contains(searchQuery) == true) {
                    filteredData.add(item)
                } else if (item.city?.lowercase(Locale.getDefault())
                        ?.contains(searchQuery) == true
                ) {
                    filteredData.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }
    interface OnAdapterListener {
        fun onClick(results: DataDestination)
    }
}

