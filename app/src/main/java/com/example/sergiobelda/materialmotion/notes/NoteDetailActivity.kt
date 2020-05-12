package com.example.sergiobelda.materialmotion.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.example.sergiobelda.materialmotion.databinding.NoteDetailActivityBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback

class NoteDetailActivity : AppCompatActivity() {
    private lateinit var binding: NoteDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        super.onCreate(savedInstanceState)
        binding = NoteDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noteId = intent.getIntExtra("noteId", 0)
        val note = notes.find { it.id == noteId }
        binding.note = note

        binding.coordinator.transitionName = noteId.toString()
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = buildContainerTransform()
        window.sharedElementReturnTransition = buildContainerTransform()

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun buildContainerTransform() =
        MaterialContainerTransform().apply {
            addTarget(binding.coordinator)
            duration = 300
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