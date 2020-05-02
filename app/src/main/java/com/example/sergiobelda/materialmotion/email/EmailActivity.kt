package com.example.sergiobelda.materialmotion.email

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.example.sergiobelda.materialmotion.databinding.EmailActivityBinding
import com.google.android.material.transition.MaterialContainerTransform

class EmailActivity : AppCompatActivity() {
    private lateinit var binding: EmailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EmailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val transform = MaterialContainerTransform().apply {
                duration = 500
                scrimColor = Color.TRANSPARENT
                interpolator = FastOutSlowInInterpolator()
                fadeMode = MaterialContainerTransform.FADE_MODE_IN
            }

            transform.startView = binding.floatingActionButton
            transform.endView = binding.card

            TransitionManager.beginDelayedTransition(binding.coordinator, transform)
            binding.card.visibility = View.VISIBLE
            binding.fabScrim.visibility = View.VISIBLE
            binding.floatingActionButton.visibility = View.INVISIBLE
        }

        binding.fabScrim.setOnClickListener {
            val transform = MaterialContainerTransform().apply {
                duration = 300
                scrimColor = Color.TRANSPARENT
                interpolator = FastOutSlowInInterpolator()
                fadeMode = MaterialContainerTransform.FADE_MODE_IN
            }

            transform.startView = binding.card
            transform.endView = binding.floatingActionButton

            TransitionManager.beginDelayedTransition(binding.coordinator, transform)
            binding.card.visibility = View.INVISIBLE
            binding.fabScrim.visibility = View.INVISIBLE
            binding.floatingActionButton.visibility = View.VISIBLE
        }
    }
}