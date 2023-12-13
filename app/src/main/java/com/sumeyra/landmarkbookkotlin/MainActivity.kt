package com.sumeyra.landmarkbookkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.sumeyra.landmarkbookkotlin.databinding.ActivityDetailsBinding
import com.sumeyra.landmarkbookkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<LandMark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Initilize the arraylist
        landmarkList= ArrayList<LandMark>()


        // Add Data
        val pisa= LandMark("Pisa","Italy",R.drawable.pisa)
        val colloseum = LandMark("Colloseum","Italy", R.drawable.colosseum)
        val eiffel = LandMark("Eiffel","France",R.drawable.eifell)
        val londonBridge = LandMark("London Bridge", "UK", R.drawable.londonbridge)

        // Add data to arraylist

        landmarkList.add(pisa)
        landmarkList.add(colloseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)

        //Adapter : Layout and Data
        //Mapping

        //Adapter: my listview have an adapter and i connect this adapter and my arrayList
        // ListView -+ADAPTER+- landmarkArraylist

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landMark -> landMark.name })
        binding.listView.adapter = adapter

        //burada position bizim ilgilendiğimiz kısım listede kaçıncı indexe tıklandığını veriyor
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // landmarkList.get(position) bununla kaçıncı indexe tıklandığını öğrenebiliriz

            val intent = Intent(MainActivity@this, DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList.get(position))
            startActivity(intent)



        }

    }
}