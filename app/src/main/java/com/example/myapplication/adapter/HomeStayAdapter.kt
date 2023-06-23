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
import com.example.myapplication.model.Data
import com.example.myapplication.model.DataHomestay
import com.example.myapplication.model.DataTourguide
import java.util.*
import kotlin.collections.ArrayList


class HomestayAdapter(val results: ArrayList<DataHomestay>, val listener: OnAdapterListener)
    : RecyclerView.Adapter<HomestayAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.card_item_homestay, parent, false)
    )

    override fun getItemCount() = results.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.findViewById<TextView>(R.id.tv_nama_homestay).text = result.title
        holder.view.findViewById<TextView>(R.id.hargaH).text = result.price_homestay.toString()
        Log.d("HomestayAdapter","resultImage: ${result.photo_homestay}")
        val url = "http://188.188.0.225:3000${result.photo_homestay}"
        Glide.with(holder.view)
            .load(url)
            .placeholder(R.drawable.grey_background)
            .error(R.drawable.grey_background)
            .centerCrop()
            .into(holder.view.findViewById(R.id.ivGambarHomestay))
        holder.view.setOnClickListener{
            listener.onClick( result )
        }
    }
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<DataHomestay>) {
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }
    interface OnAdapterListener {
        fun onClick(results: DataHomestay)
    }
}
