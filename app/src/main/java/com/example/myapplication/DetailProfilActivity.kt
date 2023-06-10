package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.fragment.FragmentNavigator
import com.example.myapplication.fragment_menu.HomeFragment

class DetailProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profil)


            val backButton: ImageView = findViewById<ImageView>(R.id.imgBackBantuan)
            backButton.setOnClickListener {
                val intent = Intent()
                intent.putExtra("checkbox_status", true)
                setResult(Activity.RESULT_OK, intent)
                finish()

            }
        }
    }