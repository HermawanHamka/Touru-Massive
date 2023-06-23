package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.DataDestination
import com.example.myapplication.model.DataTourguide
import java.util.*
import kotlin.collections.ArrayList


class TourguideAdapter(val results: ArrayList<DataTourguide>, val listener: OnAdapterListener)
    : RecyclerView.Adapter<TourguideAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.card_item_tourguide, parent, false)
    )


    override fun getItemCount() = results.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.findViewById<TextView>(R.id.tv_nama).text = result.name
        holder.view.findViewById<TextView>(R.id.hargaT).text = result.price.toString()
        Log.d("TourguideAdapter","resultImage: ${result.photo_tour}")
        val url = "http://188.188.0.225:3000${result.photo_tour}"
        Glide.with(holder.view)
            .load(url)
            .placeholder(R.drawable.grey_background)
            .error(R.drawable.grey_background)
            .centerCrop()
            .into(holder.view.findViewById(R.id.ivGambar))
        holder.view.setOnClickListener{
            listener.onClick( result )
        }
    }
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<DataTourguide>) {
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }
    interface OnAdapterListener {
        fun onClick(results: DataTourguide)
    }

}