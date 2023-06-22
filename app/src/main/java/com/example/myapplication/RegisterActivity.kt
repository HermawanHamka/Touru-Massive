package com.example.myapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.*
import com.example.myapplication.helper.Constant
import com.example.myapplication.model.ResponModel
import com.example.myapplication.retrofit_loginregister.ApiConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageView: ImageView

//    companion object{
//        val IMAGE_REQUEST_CODE = 100
//    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        /* get id */
        val daftarRegister  = findViewById<Button>(R.id.btnDaftarRegister)
        val loginRegister  = findViewById<TextView>(R.id.textLoginRegister)
        val emailRegister = findViewById<EditText>(R.id.editEmailLRegister)
        val passRegister = findViewById<EditText>(R.id.editPassRegister)
        val nameRegister = findViewById<EditText>(R.id.editUsernameRegister)
        val tanggalRegister = findViewById<EditText>(R.id.editTanggalLahir)
        val noRegister = findViewById<EditText>(R.id.editNomorRegister)
        val dummy = findViewById<Button>(R.id.btnDummyRegister)


        dummy.setOnClickListener {
            emailRegister.setText("well@gmail.com")
            passRegister.setText("well123")
            nameRegister.setText("well")
            tanggalRegister.setText("12/04/2002")
            noRegister.setText("081263")

        }
//        button = findViewById(R.id.btn_ktp)


        //pindah activity
        daftarRegister.setOnClickListener {
            register (emailRegister,passRegister,nameRegister,
                tanggalRegister,noRegister)
        }
        loginRegister.setOnClickListener {
            val pindahLogin= Intent(this, LoginActivity::class.java)
            startActivity(pindahLogin)
        }
//
//        // galeri
//        button.setOnClickListener {
//            pickImageGallery()
//        }
    }

//    private fun pickImageGallery() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, IMAGE_REQUEST_CODE)
//    }

    // tanggal lahir
    fun showDatePickerDialogs(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val tanggalLahir = findViewById<EditText>(R.id.editTanggalLahir)

        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Set the selected date in the EditText
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                tanggalLahir.setText(selectedDate)
            }, year, month, day
        )

        datePickerDialog.show()
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
//            imageView.setImageURI(data?.data)
//        }
//    }

    fun register(emailRegister:TextView, passRegister:TextView, nameRegister:TextView, /*tempatRegister:TextView,*/
                 tanggalRegister:TextView,noRegister:TextView) {
        if (emailRegister.text.isEmpty()) {
            emailRegister.error = "Kolom nama tidak boleh kosong"
            emailRegister.requestFocus()
            return
        } else if (passRegister.text.isEmpty()) {
            passRegister.error = "Kolom kata sandi tidak boleh kosong"
            passRegister.requestFocus()
            return
        } else if (nameRegister.text.isEmpty()) {
            nameRegister.error = "Kolom username tidak boleh kosong"
            nameRegister.requestFocus()
            return
        } else if (tanggalRegister.text.isEmpty()) {
            tanggalRegister.error = "Kolom tanggal lahir tidak boleh kosong"
            tanggalRegister.requestFocus()
            return
        } else if (noRegister.text.isEmpty()) {
            noRegister.error = "Kolom nomor HP tidak boleh kosong"
            noRegister.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(emailRegister.text.toString(),passRegister.text.toString(),nameRegister.text.toString(),
            tanggalRegister.text.toString(),noRegister.text.toString()  ).enqueue(object :Callback<ResponModel>{

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {

                val respon = response.body()!!
                if (!respon.token.isNullOrEmpty()){
                    Toast.makeText(this@RegisterActivity, "Pendaftaran Akun Berhasil", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@RegisterActivity, "Error:"+respon.data, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                //hedel ketika gagal
                Toast.makeText(this@RegisterActivity,"Gagal:"+t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}

