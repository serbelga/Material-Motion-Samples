package com.example.sergiobelda.materialmotion.planets

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.PlanetsActivityBinding
import com.google.android.material.transition.MaterialSharedAxis

class PlanetsActivity : AppCompatActivity() {
    private lateinit var binding: PlanetsActivityBinding
    private var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PlanetsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val fragment = PlanetFragment.newInstance(planets[selected].id)
        supportFragmentManager.commit {
            add(R.id.fragment_container, fragment, FRAGMENT_TAG)
        }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val adapter = StepAdapter(planets)
        adapter.stepClickListener = object : StepAdapter.StepClickListener {
            override fun onStepClick(position: Int) {
                val forward = position >= selected
                selected = position
                val previousFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG)
                previousFragment?.exitTransition = buildTransition(forward)
                val fragment = PlanetFragment.newInstance(planets[selected].id)
                fragment.enterTransition = buildTransition(forward)
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, fragment, FRAGMENT_TAG)
                }
            }
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
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

    private fun buildTransition(forward: Boolean) =
        MaterialSharedAxis(MaterialSharedAxis.Y, forward).apply {
            duration = 500
        }

    companion object {
        private const val FRAGMENT_TAG = "PLANET_FRAGMENT"
    }
}
