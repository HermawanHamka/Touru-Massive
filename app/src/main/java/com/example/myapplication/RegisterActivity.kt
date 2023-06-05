package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.*


import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageView: ImageView

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        /* get id */
        val daftarRegister  = findViewById<Button>(R.id.btnDaftarRegister)
        val loginRegister  = findViewById<TextView>(R.id.textLoginRegister)

        button = findViewById(R.id.btn_pick_img)
        imageView = findViewById(R.id.image_save)

        //pindah activity
        daftarRegister.setOnClickListener {
            val pindahLogin = Intent(this, LoginActivity::class.java)
            startActivity(pindahLogin)
        }
        loginRegister.setOnClickListener {
            val pindahLogin= Intent(this, LoginActivity::class.java)
            startActivity(pindahLogin)
        }

        // galeri
        button.setOnClickListener {
            pickImageGallery()
        }
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    // tanggal lahir
    fun showDatePickerDialog(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val tanggalLahir = findViewById<EditText>(R.id.tanggalLahir)

        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Set the selected date in the EditText
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                tanggalLahir.setText(selectedDate)
            }, year, month, day
        )

        datePickerDialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            imageView.setImageURI(data?.data)
        }
    }
}

