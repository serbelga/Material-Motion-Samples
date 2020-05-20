package com.example.sergiobelda.materialmotion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sergiobelda.materialmotion.databinding.MainActivityBinding
import com.example.sergiobelda.materialmotion.messages.MessagesActivity
import com.example.sergiobelda.materialmotion.music.MusicActivity
import com.example.sergiobelda.materialmotion.notes.NotesActivity
import com.example.sergiobelda.materialmotion.planets.PlanetsActivity
import com.example.sergiobelda.materialmotion.signin.SignInActivity
import com.example.sergiobelda.materialmotion.walkthrough.WalkthroughActivity

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
        binding.walkthrough.setOnClickListener {
            val intent = Intent(this, WalkthroughActivity::class.java)
            startActivity(intent)
        }
        binding.signIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        binding.music.setOnClickListener {
            val intent = Intent(this, MusicActivity::class.java)
            startActivity(intent)
        }
        binding.notes.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }
        binding.email.setOnClickListener {
            val intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
        }
    }
}
