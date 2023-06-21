package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.model.DestinasiModel
import com.example.myapplication.R
import com.example.myapplication.model.Data
import com.example.myapplication.model.DataDestination

class DestinasiAdapter(val results: ArrayList<DataDestination>, val listener: OnAdapterListener)
    : RecyclerView.Adapter<DestinasiAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_destinasi, parent, false)
    )

    override fun getItemCount() = results.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.findViewById<TextView>(R.id.namaDestinasi).text = result.title
        Log.d("DestinasiAdapter","resultImage: ${result.photo}")
        val url = "http://192.168.100.6:3000${result.photo}"
        Glide.with(holder.view)
            .load(url)
            .placeholder(R.drawable.grey_background)
            .error(R.drawable.grey_background)
            .centerCrop()
            .into(holder.view.findViewById(R.id.gambarDestinasi))
        holder.view.setOnClickListener{
            listener.onClick( result )
        }
    }
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<DataDestination>) {
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }
    interface OnAdapterListener {
        fun onClick(results: DataDestination)
    }
}

