package com.sumeyra.landmarkbookkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sumeyra.landmarkbookkotlin.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        //intent karşılama
        val intent = intent
        //casting
        val selectedLandmark= intent.getSerializableExtra("landmark") as LandMark

        //eşleştirme
        binding.landmarkText.text= selectedLandmark.name
        binding.countryText.text= selectedLandmark.country
        binding.imageView.setImageResource(selectedLandmark.image)


    }
}