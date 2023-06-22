package com.example.myapplication


import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TransaksiActivity:AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        val pesan = findViewById<Button>(R.id.btnPesan)

        pesan.setOnClickListener {
            val pindahPilih = Intent(this, PilihPembayaranActivity::class.java)
            startActivity(pindahPilih)
        }
        val backButton: ImageView = findViewById(R.id.imgBackTransaksi)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    fun showDatePickerDialog(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val singgah = findViewById<EditText>(R.id.tanggalSinggah)

        val datePickerDialogSinggah = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Set the selected date in the EditText
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                singgah.setText(selectedDate)
            }, year, month, day
        )

        datePickerDialogSinggah.show()


    }

    fun showDatePickerDialogKeluar(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val keluar = findViewById<EditText>(R.id.tanggalKeluar)

        val datePickerDialogKeluar = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Set the selected date in the EditText
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                keluar.setText(selectedDate)
            }, year, month, day
        )

        datePickerDialogKeluar.show()
    }
}
