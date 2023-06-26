package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.DataHomestay
import java.util.*
import kotlin.collections.ArrayList

class HomestayAdapter(
    private var originalData: ArrayList<DataHomestay>,
    private var filteredData: ArrayList<DataHomestay>,
    private val listener: OnAdapterListener
) : RecyclerView.Adapter<HomestayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_homestay, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filteredData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = filteredData[position]
        holder.bind(result)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNamaHomestay: TextView = itemView.findViewById(R.id.tv_nama_homestay)
        private val hargaH: TextView = itemView.findViewById(R.id.hargaH)
        private val cityH: TextView = itemView.findViewById(R.id.cityH)
        private val ivGambarHomestay: ImageView = itemView.findViewById(R.id.ivGambarHomestay)


        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val result = filteredData[position]
                    listener.onClick(result)
                }
            }
        }

        fun bind(data: DataHomestay) {
            tvNamaHomestay.text = data.title
            cityH.text = data.city
            hargaH.text = data.price_homestay.toString()
            val url = "http://192.168.100.7:3000${data.photo_homestay}"
            Glide.with(itemView)
                .load(url)
                .placeholder(R.drawable.grey_background)
                .error(R.drawable.grey_background)
                .centerCrop()
                .into(ivGambarHomestay)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<DataHomestay>) {
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
                } else if (item.price_homestay.toString().contains(searchQuery)){
                    filteredData.add(item)
                } else if (item.city?.lowercase(Locale.getDefault())?.contains(searchQuery) == true) {
                    filteredData.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(results: DataHomestay)
    }
}
