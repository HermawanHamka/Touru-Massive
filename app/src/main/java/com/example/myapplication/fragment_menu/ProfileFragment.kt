package com.example.myapplication.fragment_menu

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.DetailProfilActivity
import com.example.myapplication.RiwayatTransaksiActivity
import com.example.myapplication.BantuanActivity
import com.example.myapplication.TentangKamiActivity
import com.example.myapplication.LoginActivity
import com.example.myapplication.*
import com.example.myapplication.helper.PreferenceHelper



class ProfileFragment : Fragment() {

    lateinit var edit:TextView
    lateinit var riwayat:TextView
    lateinit var bantuan:TextView
    lateinit var tentang:TextView
    private lateinit var keluar:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* get id */
        edit = view.findViewById(R.id.txtEditProfil)
        riwayat  =view.findViewById(R.id.txtRiwayatTransaksi)
        bantuan = view.findViewById(R.id.txtBantuan)
        tentang = view.findViewById(R.id.txtTentangKami)
        keluar = view.findViewById(R.id.txtKeluar)

        /* click the button */
        edit.setOnClickListener {
            val pindahProfil = Intent(activity, DetailProfilActivity::class.java)
            startActivity(pindahProfil)
        }
        riwayat.setOnClickListener {
            val pindahRiwayat = Intent(activity, RiwayatTransaksiActivity::class.java)
            startActivity(pindahRiwayat)
        }
        bantuan.setOnClickListener {
            val pindahBantuan = Intent(activity, BantuanActivity::class.java)
            startActivity(pindahBantuan)
        }
        tentang.setOnClickListener {
            val pindahTentang = Intent(activity, TentangKamiActivity::class.java)
            startActivity(pindahTentang)
        }
        keluar.setOnClickListener {
            val pindahHome = Intent(activity, KeluarActivity::class.java)
            startActivity(pindahHome)
        }

    }


}