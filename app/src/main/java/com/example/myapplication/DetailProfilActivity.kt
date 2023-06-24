package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
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
        val passProfile = findViewById<TextView>(R.id.profilePass)
        val nameProfile = findViewById<TextView>(R.id.profileNama)
        val noProfile = findViewById<TextView>(R.id.profileNo)

        emailProfile.text = sharedPref.getString(Constant.PREF_EMAIL)
        passProfile.text = sharedPref.getString(Constant.PREF_PASSWORD)
        nameProfile.text = sharedPref.getString(Constant.PREF_USERNAME)
        noProfile.text = sharedPref.getString(Constant.PREF_NOMOR)
        }


        }
