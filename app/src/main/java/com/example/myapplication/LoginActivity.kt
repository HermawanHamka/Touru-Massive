package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.app.ApiConfig
import com.example.myapplication.fragment_menu.HomeFragment
import com.example.myapplication.helper.Constant
import com.example.myapplication.helper.PreferenceHelper
import com.example.myapplication.model.ResponModel
import com.google.android.material.textfield.TextInputEditText
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPref : PreferenceHelper // menjalankan init di preferencehelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPref = PreferenceHelper(this)

        /* get id */
        val lupaSandi  = findViewById<TextView>(R.id.lupaKataSandiLogin)
        val daftar  = findViewById<TextView>(R.id.textDaftarLogin)
        val login = findViewById<Button>(R.id.btnMasukHome)
        val editEmail = findViewById<EditText>(R.id.editEmailLogin)
        val editPass = findViewById<EditText>(R.id.editPassLogin)
        val dummy = findViewById<Button>(R.id.btnDummy)

        //pindah activity
        lupaSandi.setOnClickListener {
            val pindahLogin = Intent(this, LupaPassActivity::class.java)
            startActivity(pindahLogin)
        }
        daftar.setOnClickListener {
            val pindahDaftar = Intent(this, RegisterActivity::class.java)
            startActivity(pindahDaftar)
        }
        login.setOnClickListener {
            login(editEmail,editPass)
        }
//        dummy.setOnClickListener {
//            editEmail.setText("kminchelle")
//            editPass.setText("0lelplR")
//        }
        dummy.setOnClickListener {
            editEmail.setText("dito@gmail.com")
            editPass.setText("dito123")
        }

    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    fun login(editEmail:TextView, editPass:TextView) {
        if (editEmail.text.isEmpty()) {
            editEmail.error = "Kolom nama tidak boleh kosong"
            editEmail.requestFocus()
            return
        } else if (editPass.text.isEmpty()) {
            editPass.error = "Kolom kata sandi tidak boleh kosong"
            editPass.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.login(editEmail.text.toString(),editPass.text.toString()).enqueue(object : Callback<ResponModel> {

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {


                val respon = response.body()!!
                if (!respon.token.isNullOrEmpty()){
                    sharedPref.put(Constant.PREF_EMAIL, editEmail.text.toString())
                    sharedPref.put(Constant.PREF_PASSWORD, editPass.text.toString())
                    sharedPref.put(Constant.PREF_IS_LOGIN,true)
                    moveIntent()
                    finish()
                    Toast.makeText(this@LoginActivity, "Selamat datang diTouru", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LoginActivity, "Error:"+respon.data, Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                //hedel ketika gag
                Toast.makeText(this@LoginActivity,"Gagal:"+t.message, Toast.LENGTH_SHORT).show()
            }

        })


    }
    private fun moveIntent(){
        startActivity(Intent(this, NavbarActivity::class.java))
        finish()
    }
}