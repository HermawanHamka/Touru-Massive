package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TransaksiActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        val pesan = findViewById<Button>(R.id.btnPesan)

        pesan.setOnClickListener {
            val pindahBukti = Intent(this, BuktiActivity::class.java)
            startActivity(pindahBukti)
        }


        }
    }
