package com.example.sergiobelda.materialmotion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sergiobelda.materialmotion.databinding.MainActivityBinding
import com.example.sergiobelda.materialmotion.messages.MessagesActivity
import com.example.sergiobelda.materialmotion.music.MusicActivity
import com.example.sergiobelda.materialmotion.planets.PlanetsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.solarSystem.setOnClickListener {
            val intent = Intent(this, PlanetsActivity::class.java)
            startActivity(intent)
        }
        binding.music.setOnClickListener {
            val intent = Intent(this, MusicActivity::class.java)
            startActivity(intent)
        }
        binding.email.setOnClickListener {
            val intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
        }
    }
}
