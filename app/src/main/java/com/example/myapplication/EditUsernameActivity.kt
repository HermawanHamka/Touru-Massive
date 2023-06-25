package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.helper.Constant
import com.example.myapplication.helper.PreferenceHelper

class EditUsernameActivity : AppCompatActivity() {
    lateinit var sharedPref : PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_username)

        sharedPref = PreferenceHelper(this)

        val backButton: ImageView = findViewById<ImageView>(R.id.imgBackUbahUsername)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        val ubahUsername = findViewById<TextView>(R.id.usernameTerdaftar)

        ubahUsername.text = sharedPref.getString(Constant.PREF_USERNAME)
    }
}