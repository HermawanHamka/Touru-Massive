package com.example.myapplication.fragment_menu

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.DetailProfilActivity
import com.example.myapplication.HomestayActivity
import com.example.myapplication.R
import com.example.myapplication.TourguideActivity
import com.example.myapplication.helper.Constant
import com.example.myapplication.helper.PreferenceHelper
import retrofit2.http.Url

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    // TODO: Rename and change types of parameters
    lateinit var sharedPref : PreferenceHelper
    lateinit var buttonTourGuide : ImageView
    lateinit var buttonHomestay : ImageView
    lateinit var homestay : LinearLayout
    lateinit var halo : TextView
    lateinit var tourguide : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        buttonHomestay = view.findViewById<ImageView>(R.id.imageView7)
        buttonTourGuide = view.findViewById<ImageView>(R.id.imageView9)
        homestay = view.findViewById(R.id.layoutHomestay)
        tourguide = view.findViewById(R.id.layoutTourguide)
        halo = view.findViewById(R.id.textView)
        sharedPref = PreferenceHelper(requireContext())

        val email = sharedPref.getString(Constant.PREF_USERNAME)
        halo.text = "Halo " + (email ?: "")

        buttonHomestay.setOnClickListener{
            val pindah = Intent(activity, HomestayActivity::class.java)
            startActivity(pindah)
        }

        buttonTourGuide.setOnClickListener{
            val pindah = Intent(activity, TourguideActivity::class.java)
            startActivity(pindah)
        }
        homestay.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("http://188.188.0.225:3000/homestays")
            requireActivity().startActivity(urlIntent)
        }
        tourguide.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("http://188.188.0.225:3000/tours")
            requireActivity().startActivity(urlIntent)
        }



    }
}