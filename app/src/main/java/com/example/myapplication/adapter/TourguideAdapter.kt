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

import com.example.myapplication.model.DataTourguide
import java.util.*
import kotlin.collections.ArrayList


class TourguideAdapter(
    private var originalData:  ArrayList<DataTourguide>,
    private var filteredData: ArrayList<DataTourguide>,
    private val listener: OnAdapterListener,

    ) : RecyclerView.Adapter<TourguideAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_tourguide, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filteredData.size
    }

    override fun onBindViewHolder(holder: TourguideAdapter.ViewHolder, position: Int) {
        val result = filteredData[position]
        holder.bind(result)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNamaTourguide: TextView = itemView.findViewById(R.id.tv_nama)
        private val hargaT: TextView = itemView.findViewById(R.id.hargaT)
        private val ivGambarTourguide: ImageView = itemView.findViewById(R.id.ivGambar)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val result = filteredData[position]
                    listener.onClick(result)
                }
            }
        }

        fun bind(data: DataTourguide) {
            tvNamaTourguide.text = data.title
            hargaT.text = data.price.toString()
            val url = "http://192.168.100.7:3000${data.photo_tour}"
            Glide.with(itemView)
                .load(url)
                .placeholder(R.drawable.grey_background)
                .error(R.drawable.grey_background)
                .centerCrop()
                .into(ivGambarTourguide)
        }
      }
     @SuppressLint("NotifyDataSetChanged")
        fun setData(data: ArrayList<DataTourguide>) {
        originalData = data
        filterData("") // Apply initial filtering
        }

    fun filterData(query: String) {
        filteredData.clear()
        if (query.isEmpty()) {
            filteredData.addAll(originalData) // Show all data if query is empty
        } else {
            val searchQuery = query.toLowerCase(Locale.getDefault())
            for (item in originalData) {
                if (item.title?.toLowerCase(Locale.getDefault())?.contains(searchQuery) == true) {
                    filteredData.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(results: DataTourguide)
    }

    }