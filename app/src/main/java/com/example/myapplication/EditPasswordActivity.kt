package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView

class EditPasswordActivity : AppCompatActivity() {

    private lateinit var btnUbah: Button
    private lateinit var editBaru: EditText
    private lateinit var editKonfirm: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_password)

        /* get id */
        btnUbah = findViewById(R.id.btnUbahPass)
        editBaru = findViewById(R.id.editPassBaru)
        editKonfirm = findViewById(R.id.editPassKonfirmasi)

        editBaru.addTextChangedListener(loginTextWatcher)
        editKonfirm.addTextChangedListener(loginTextWatcher)

        val backButton: ImageView = findViewById(R.id.imgBackUbahSandi)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editBaru = editBaru.text.toString().trim()
            val editKonfirm = editKonfirm.text.toString().trim()

            btnUbah.isEnabled = editBaru.isNotEmpty()
            btnUbah.isEnabled = editKonfirm.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }
}