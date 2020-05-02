package com.example.sergiobelda.materialmotion.email

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.MenuItem
import android.view.View
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.EmailActivityBinding
import com.google.android.material.transition.MaterialContainerTransform

class EmailActivity : AppCompatActivity() {
    private lateinit var binding: EmailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EmailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.messages)

        binding.floatingActionButton.setOnClickListener {
            val transition = buildTransition()

            transition.startView = binding.floatingActionButton
            transition.endView = binding.card

            TransitionManager.beginDelayedTransition(binding.coordinator, transition)
            binding.card.visibility = View.VISIBLE
            binding.fabScrim.visibility = View.VISIBLE
            binding.floatingActionButton.visibility = View.INVISIBLE
        }

        binding.fabScrim.setOnClickListener {
            val transition = buildTransition()

            transition.startView = binding.card
            transition.endView = binding.floatingActionButton

            TransitionManager.beginDelayedTransition(binding.coordinator, transition)
            binding.card.visibility = View.INVISIBLE
            binding.fabScrim.visibility = View.INVISIBLE
            binding.floatingActionButton.visibility = View.VISIBLE
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MessagesAdapter(messages)

        binding.cardRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.cardRecyclerView.adapter = ContactsAdapter(favContacts)
    }

    private fun buildTransition() =
        MaterialContainerTransform().apply {
            duration = 300
            scrimColor = Color.TRANSPARENT
            interpolator = FastOutSlowInInterpolator()
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
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