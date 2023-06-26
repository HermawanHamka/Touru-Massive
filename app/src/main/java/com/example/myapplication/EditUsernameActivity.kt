package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.helper.Constant
import com.example.myapplication.helper.PreferenceHelper

class EditUsernameActivity : AppCompatActivity() {
    lateinit var sharedPref : PreferenceHelper
    private lateinit var editUsername: EditText
    private lateinit var btnUbahUsername: Button
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
        editUsername = findViewById(R.id.ubahUsername)
        btnUbahUsername= findViewById(R.id.btnUbahUsername)
        editUsername.addTextChangedListener(loginTextWatcher)
    }
    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editUsername = editUsername.text.toString().trim()

            btnUbahUsername .isEnabled = editUsername.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }
}