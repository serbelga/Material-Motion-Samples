/*
 * Copyright 2021 Sergio Belda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.sergiobelda.samples.materialmotion.notes

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.card.MaterialCardView
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import dev.sergiobelda.samples.materialmotion.databinding.NotesActivityBinding

class NotesActivity : AppCompatActivity() {
    private lateinit var binding: NotesActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        binding = NotesActivityBinding.inflate(layoutInflater)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setClickListeners()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val adapter = NotesAdapter(notes)
        adapter.noteClickListener =
            object : NotesAdapter.NoteClickListener {
                override fun onNoteClick(
                    id: Int,
                    noteCard: MaterialCardView,
                ) {
                    val intent = Intent(this@NotesActivity, NoteDetailActivity::class.java)
                    val options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this@NotesActivity,
                            noteCard,
                            id.toString(),
                        )
                    intent.putExtra("noteId", id)
                    startActivity(intent, options.toBundle())
                }
            }
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter
    }

    private fun setClickListeners() {
        binding.addNoteFab.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            val options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    binding.addNoteFab,
                    "shared_element_end_root",
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

    override fun onBackPressed() {
        finish()
    }
}
