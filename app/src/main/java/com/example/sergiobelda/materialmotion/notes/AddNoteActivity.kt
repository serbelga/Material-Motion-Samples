package com.example.sergiobelda.materialmotion.notes

import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.AddNoteActivityBinding
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: AddNoteActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        binding = AddNoteActivityBinding.inflate(layoutInflater)
        binding.coordinator.transitionName = "shared_element_end_root"
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = buildContainerTransform()
        window.sharedElementReturnTransition = buildContainerTransform()
        setContentView(binding.coordinator)
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_round_clear_24)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun buildContainerTransform() =
        MaterialContainerTransform().apply {
            addTarget(binding.coordinator)
            setAllContainerColors(MaterialColors.getColor(binding.root, R.attr.colorSurface))
            pathMotion = MaterialArcMotion()
            duration = 500
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
