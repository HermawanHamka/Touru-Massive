package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.fragment.DestinasiFragment
import com.example.myapplication.fragment.HomeFragment
import com.example.myapplication.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val destinasiFragment = DestinasiFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation =findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_destinasi -> makeCurrentFragment(destinasiFragment)
                R.id.menu_profile -> makeCurrentFragment(profileFragment)
            }
            true

        }
        supportActionBar?.hide()

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }


}