package com.example.myapplication.adapter

<<<<<<< HEAD
=======
import android.annotation.SuppressLint
>>>>>>> 871b5c5 (destinasi dan login)
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.model.DestinasiModel
import com.example.myapplication.R
<<<<<<< HEAD

class DestinasiAdapter(val results: ArrayList<DestinasiModel.Result>, val listener: OnAdapterListener)
=======
import com.example.myapplication.model.Data
import com.example.myapplication.model.DataDestination

class DestinasiAdapter(val results: ArrayList<DataDestination>, val listener: OnAdapterListener)
>>>>>>> 871b5c5 (destinasi dan login)
    : RecyclerView.Adapter<DestinasiAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_destinasi, parent, false)
    )

    override fun getItemCount() = results.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.findViewById<TextView>(R.id.namaDestinasi).text = result.title
<<<<<<< HEAD
        Log.d("DestinasiAdapter","resultImage: ${result.image}")
        Glide.with(holder.view)
            .load(result.image)
=======
        Log.d("DestinasiAdapter","resultImage: ${result.photo}")
        val url = "http://192.168.100.6:3000${result.photo}"
        Glide.with(holder.view)
            .load(url)
>>>>>>> 871b5c5 (destinasi dan login)
            .placeholder(R.drawable.grey_background)
            .error(R.drawable.grey_background)
            .centerCrop()
            .into(holder.view.findViewById(R.id.gambarDestinasi))
        holder.view.setOnClickListener{
            listener.onClick( result )
        }
    }
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

<<<<<<< HEAD
    fun setData(data: List<DestinasiModel.Result>) {
=======
    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<DataDestination>) {
>>>>>>> 871b5c5 (destinasi dan login)
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }
    interface OnAdapterListener {
<<<<<<< HEAD
        fun onClick(results: DestinasiModel.Result)
    }
}

//class DestinasiAdapter(private val context: Context, private val destinasi: List<HeroDestinasi>, val listener: (HeroDestinasi) -> Unit)
//    : RecyclerView.Adapter<DestinasiAdapter.DestinasiViewHolder>(){
//
//    class DestinasiViewHolder(view: View) : RecyclerView.ViewHolder(view){
//
//        val imgDestinasi = view.findViewById<RelativeLayout>(R.id.imageDestinasi)
//        val namaDestinasi = view.findViewById<TextView>(R.id.namaDestinasi)
//
//        fun bindView(destinasi: HeroDestinasi, listener: (HeroDestinasi) -> Unit) {
//            imgDestinasi.setBackgroundResource(destinasi.imgDestinasi)
//            namaDestinasi.text = destinasi.namaDestinasi
//            itemView.setOnClickListener{
//                listener(destinasi)}
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinasiViewHolder {
//        return DestinasiViewHolder(
//            LayoutInflater.from(context).inflate(R.layout.list_item_destinasi, parent, false)
//        )
//    }
//    override fun onBindViewHolder(holder: DestinasiViewHolder, position: Int) {
//        holder.bindView(destinasi[position], listener)
//    }
//    override fun getItemCount(): Int = destinasi.size
//}
=======
        fun onClick(results: DataDestination)
    }
}

>>>>>>> 871b5c5 (destinasi dan login)
