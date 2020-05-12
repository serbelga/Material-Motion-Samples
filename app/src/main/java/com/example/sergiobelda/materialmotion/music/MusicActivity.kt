package com.example.sergiobelda.materialmotion.music

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.MusicActivityBinding

class MusicActivity : AppCompatActivity() {
    private lateinit var binding: MusicActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MusicActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.bottomNavigationView.inflateMenu(R.menu.navigation_menu)
        NavigationUI.setupWithNavController(
            binding.bottomNavigationView,
            findNavController(R.id.nav_host_fragment)
        )
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.artistsFragment,
                R.id.albumsFragment,
                R.id.playlistsFragment
            )
        )
        val navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.albumFragment -> {
                    binding.appbarLayout.setExpanded(false, false)
                }
                else -> {
                    binding.appbarLayout.setExpanded(true, true)
                }
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
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