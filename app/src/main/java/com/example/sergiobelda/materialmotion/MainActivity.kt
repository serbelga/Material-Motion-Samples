package com.example.sergiobelda.materialmotion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sergiobelda.materialmotion.databinding.MainActivityBinding
import com.example.sergiobelda.materialmotion.sharedaxis.SharedAxisYActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sharedAxis.setOnClickListener {
            val intent = Intent(this, SharedAxisYActivity::class.java)
            startActivity(intent)
        }
    }
}
