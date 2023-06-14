package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback_activity)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val button = findViewById<Button>(R.id.btnKirimFeedBack)
        val ratingScale = findViewById<TextView>(R.id.tv_rating)

        ratingBar.setOnRatingBarChangeListener { rBar, rating, fromUser ->
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
            val message = ratingBar.rating.toString()
            Toast.makeText(this@FeedbackActivity, "Rating Is :" + message, Toast.LENGTH_SHORT).show()
        }
    }

}