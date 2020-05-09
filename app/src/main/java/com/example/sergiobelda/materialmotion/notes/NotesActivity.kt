package com.example.sergiobelda.materialmotion.notes

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sergiobelda.materialmotion.databinding.NotesActivityBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback

class NotesActivity : AppCompatActivity() {
    private lateinit var binding: NotesActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        binding = NotesActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false

        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setClickListeners()

        setRecyclerView()
    }

    private fun setRecyclerView() {
        val adapter = NotesAdapter(notes)
        adapter.noteClickListener = object : NotesAdapter.NoteClickListener {
            override fun onNoteClick(id: Int, noteCard: MaterialCardView) {
                val intent = Intent(this@NotesActivity, NoteDetailActivity::class.java)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@NotesActivity, noteCard, id.toString()
                )
                intent.putExtra("noteId", id)
                startActivity(intent, options.toBundle())
            }
        }
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter
    }

    private fun setClickListeners() {
        binding.addNoteFab.transitionName = "shared_element"
        binding.addNoteFab.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, binding.addNoteFab, "shared_element"
            )
            startActivity(intent, options.toBundle())
        }
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