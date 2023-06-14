package com.example.myapplication.fragment_menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DetailDestinasi
import com.example.myapplication.R
import com.example.myapplication.adapter.DestinasiAdapter
import com.example.myapplication.find
import com.example.myapplication.model.HeroDestinasi

class DestinasiFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destinasi, container, false)

    }

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val destinasiList = listOf<HeroDestinasi>(
            HeroDestinasi(
                R.drawable.kawah_putih,
                "Kawah Putih",
            "bla bla bla"
            ),
            HeroDestinasi(
                R.drawable.bali,
                "Bali",
            "bla bla bla"
            ),
            HeroDestinasi(
                R.drawable.pulau_komodo,
                "Pulau Komodo",
            "bla bla bla"
            ),
            HeroDestinasi(
                R.drawable.candi_borobudur,
                "Borobudur",
            "bla bla bla"
            ),
            HeroDestinasi(
                R.drawable.raja_ampat,
                "Raja Ampat",
                "bla bla bla"
            ),
            HeroDestinasi(
                R.drawable.labuan_bajo,
                "Labuan Bajo",
                "bla bla bla"
            )
        )

        val recyclerView by lazy { find<RecyclerView>(R.id.rv_heroes) }
        recyclerView.layoutManager = GridLayoutManager(this.context,2, GridLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = this.context?.let {
            DestinasiAdapter(it, destinasiList) {
                    val intent = Intent(this.context, DetailDestinasi::class.java)
                    intent.putExtra(INTENT_PARCELABLE, it)
                    startActivity(intent)
            }
        }
    }
}