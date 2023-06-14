package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.HeroDestinasi

class DestinasiAdapter(private val context: Context, private val destinasi: List<HeroDestinasi>, val listener: (HeroDestinasi) -> Unit)
    : RecyclerView.Adapter<DestinasiAdapter.DestinasiViewHolder>(){

    class DestinasiViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val imgDestinasi = view.findViewById<RelativeLayout>(R.id.imageDestinasi)
        val namaDestinasi = view.findViewById<TextView>(R.id.namaDestinasi)

        fun bindView(destinasi: HeroDestinasi, listener: (HeroDestinasi) -> Unit) {
            imgDestinasi.setBackgroundResource(destinasi.imgDestinasi)
            namaDestinasi.text = destinasi.namaDestinasi
            itemView.setOnClickListener{
                listener(destinasi)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinasiViewHolder {
        return DestinasiViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item_destinasi, parent, false)
        )
    }
    override fun onBindViewHolder(holder: DestinasiViewHolder, position: Int) {
        holder.bindView(destinasi[position], listener)
    }
    override fun getItemCount(): Int = destinasi.size
}