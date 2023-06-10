package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.HeroTourguide
import com.example.myapplication.R
import java.util.*



class ListHeroAdapter(private val listHeroTourguides: ArrayList<HeroTourguide>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, ratingg ) = listHeroTourguides[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.rating.text = ratingg
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHeroTourguides[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int = listHeroTourguides.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.tvGambar)
        val tvName: TextView = itemView.findViewById(R.id.tv_nama)
        val tvDescription: TextView = itemView.findViewById(R.id.harga)
        val rating : TextView = itemView.findViewById(R.id.rating)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: HeroTourguide)
    }
}
