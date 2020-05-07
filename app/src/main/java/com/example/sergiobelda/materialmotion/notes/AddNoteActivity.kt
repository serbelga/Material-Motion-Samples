package com.example.sergiobelda.materialmotion.notes

import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.AddNoteActivityBinding
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback


class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: AddNoteActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        binding = AddNoteActivityBinding.inflate(layoutInflater)
        setContentView(binding.coordinator)

        binding.coordinator.transitionName = "shared_element"
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = buildContainerTransform()
        window.sharedElementReturnTransition = buildContainerTransform()

        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_round_clear_24)
    }

    private fun buildContainerTransform(): MaterialContainerTransform? {
        val transform = MaterialContainerTransform()
        transform.addTarget(binding.coordinator)
        transform.duration = 500
        transform.pathMotion = MaterialArcMotion()
        transform.interpolator = FastOutSlowInInterpolator()
        transform.fadeMode = MaterialContainerTransform.FADE_MODE_IN
        return transform
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