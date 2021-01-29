package com.example.sergiobelda.materialmotion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sergiobelda.materialmotion.databinding.MainActivityBinding
import com.example.sergiobelda.materialmotion.sample.SampleItem
import com.example.sergiobelda.materialmotion.sample.SamplesAdapter
import com.example.sergiobelda.materialmotion.sample.samples

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val samplesAdapter = SamplesAdapter(samples).apply {
            listener = object : SamplesAdapter.OnSampleClickListener {
                override fun onSampleClick(sampleItem: SampleItem) {
                    startActivity(Intent(this@MainActivity, sampleItem.activity))
                }
            }
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = samplesAdapter
        }
    }
}
