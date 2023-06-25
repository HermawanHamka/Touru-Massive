package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigator
import com.example.myapplication.fragment_menu.HomeFragment
import com.example.myapplication.helper.Constant
import com.example.myapplication.helper.PreferenceHelper
import com.example.myapplication.model.ResponModel
import com.example.myapplication.retrofit_loginregister.ApiConfig

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailProfilActivity : AppCompatActivity() {
    lateinit var sharedPref : PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profil)

        sharedPref = PreferenceHelper(this)

        val backButton: ImageView = findViewById<ImageView>(R.id.imgBackBantuan)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        val emailProfile = findViewById<TextView>(R.id.profileEmail)
        val lahirProfile = findViewById<TextView>(R.id.profileLahir)
        val nameProfile = findViewById<TextView>(R.id.profileNama)
        val noProfile = findViewById<TextView>(R.id.profileNo)
        val kataSandi = findViewById<LinearLayout>(R.id.linearLayoutKataSandi)
        val username = findViewById<LinearLayout>(R.id.linearLayoutUsername)

        emailProfile.text = sharedPref.getString(Constant.PREF_EMAIL)
        nameProfile.text = sharedPref.getString(Constant.PREF_USERNAME)
        lahirProfile.text = sharedPref.getString(Constant.PREF_TGLLAHIR)
        noProfile.text = sharedPref.getString(Constant.PREF_NOMOR)

        kataSandi.setOnClickListener {
            val pindah = Intent(this,EditPasswordActivity::class.java)
            startActivity(pindah)
        }

        username.setOnClickListener {
            val pindahUsername = Intent(this,EditUsernameActivity::class.java)
            startActivity(pindahUsername)
        }


        }


        }
