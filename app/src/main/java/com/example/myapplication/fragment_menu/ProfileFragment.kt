package com.example.myapplication.fragment_menu

import android.content.Intent
<<<<<<< HEAD
=======
import android.content.SharedPreferences
>>>>>>> 871b5c5 (destinasi dan login)
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
<<<<<<< HEAD
=======
import android.widget.Toast
>>>>>>> 871b5c5 (destinasi dan login)
import com.example.myapplication.DetailProfilActivity
import com.example.myapplication.RiwayatTransaksiActivity
import com.example.myapplication.BantuanActivity
import com.example.myapplication.TentangKamiActivity
import com.example.myapplication.LoginActivity
import com.example.myapplication.*
<<<<<<< HEAD
=======
import com.example.myapplication.helper.PreferenceHelper
>>>>>>> 871b5c5 (destinasi dan login)



class ProfileFragment : Fragment() {

<<<<<<< HEAD
   lateinit var edit:TextView
     lateinit var riwayat:TextView
    lateinit var bantuan:TextView
 lateinit var tentang:TextView
    lateinit var keluar:TextView

=======
    lateinit var edit:TextView
    lateinit var riwayat:TextView
    lateinit var bantuan:TextView
    lateinit var tentang:TextView
    private lateinit var keluar:TextView
>>>>>>> 871b5c5 (destinasi dan login)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

<<<<<<< HEAD

=======
>>>>>>> 871b5c5 (destinasi dan login)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD

        /* get id */
        edit = view.findViewById(R.id.txtEditProfil)
         riwayat  =view.findViewById(R.id.txtRiwayatTransaksi)
         bantuan = view.findViewById(R.id.txtBantuan)
         tentang = view.findViewById(R.id.txtTentangKami)
=======
        /* get id */
        edit = view.findViewById(R.id.txtEditProfil)
        riwayat  =view.findViewById(R.id.txtRiwayatTransaksi)
        bantuan = view.findViewById(R.id.txtBantuan)
        tentang = view.findViewById(R.id.txtTentangKami)
>>>>>>> 871b5c5 (destinasi dan login)
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
<<<<<<< HEAD
            keluar.setOnClickListener {
            val pindahKeluar = Intent(activity, LoginActivity::class.java)
            startActivity(pindahKeluar)
=======
        keluar.setOnClickListener {
            val pindahHome = Intent(activity, KeluarActivity::class.java)
            startActivity(pindahHome)
>>>>>>> 871b5c5 (destinasi dan login)
        }

    }


}