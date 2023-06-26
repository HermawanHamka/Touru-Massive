package com.example.myapplication

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.myapplication.fragment_menu.ProfileFragment

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback_activity)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val button = findViewById<Button>(R.id.btnKirimFeedBack)
        val ratingScale = findViewById<TextView>(R.id.tv_rating)

        ratingBar.setOnRatingBarChangeListener { rBar, rating, userRating ->
            ratingScale.text = rating.toString()
            when (rBar.rating.toInt()){
                1 -> ratingScale.text="Very Bad"
                2 -> ratingScale.text="Bad"
                3 -> ratingScale.text="Good"
                4 -> ratingScale.text="Very Good"
                5 -> ratingScale.text="Awesome"
                else -> ratingScale.text= " "
            }
        }
        button.setOnClickListener {
            val popUpBinding = layoutInflater.inflate(R.layout.activity_popup_menu, null)
            val popUp = Dialog(this)
            popUp.setContentView(popUpBinding)

            popUp.setCancelable(true)
            popUp.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            popUp.show()

            val okButton = popUpBinding.findViewById<AppCompatButton>(R.id.btn_confirm)
            okButton.setOnClickListener{
                val pindahMenu = Intent(this, NavbarActivity::class.java)
                startActivity(pindahMenu)
            }
        }
    }

}