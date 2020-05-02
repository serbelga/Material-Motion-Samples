package com.example.sergiobelda.materialmotion.music

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.MusicActivityBinding

class MusicActivity : AppCompatActivity() {
    private lateinit var binding: MusicActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MusicActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.bottomNavigationView.inflateMenu(R.menu.navigation_menu)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, findNavController(R.id.nav_host_fragment))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                true
            }
        }
    }
}