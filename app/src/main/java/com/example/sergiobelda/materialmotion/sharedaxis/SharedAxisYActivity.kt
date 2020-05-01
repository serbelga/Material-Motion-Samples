package com.example.sergiobelda.materialmotion.sharedaxis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.SharedAxisYActivityBinding
import com.google.android.material.transition.MaterialSharedAxis

class SharedAxisYActivity : AppCompatActivity() {
    private lateinit var binding: SharedAxisYActivityBinding
    private var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SharedAxisYActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fragment = PlanetFragment.newInstance(planets[selected].id)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val adapter = StepAdapter(planets)
        adapter.stepClickListener = object : StepAdapter.StepClickListener {
            override fun onStepClick(position: Int) {
                val forward = position >= selected
                selected = position
                val fragment = PlanetFragment.newInstance(planets[selected].id)
                fragment.enterTransition = MaterialSharedAxis.create(MaterialSharedAxis.Y, forward)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
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
}