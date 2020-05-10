package com.example.sergiobelda.materialmotion.messages

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.MenuItem
import android.view.View
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sergiobelda.materialmotion.databinding.MessagesActivityBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFade

class MessagesActivity : AppCompatActivity() {
    private lateinit var binding: MessagesActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MessagesActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setClickListeners()

        setRecyclerViews()

        binding.floatingActionButton.post {
            val transition = MaterialFade.create(true).apply {
                duration = 5000
            }
            TransitionManager.beginDelayedTransition(binding.root, transition)
            binding.floatingActionButton.visibility = View.VISIBLE
        }
    }

    private fun setClickListeners() {
        binding.floatingActionButton.setOnClickListener {
            val transition = buildContainerTransformation()

            transition.startView = binding.floatingActionButton
            transition.endView = binding.card

            TransitionManager.beginDelayedTransition(binding.root, transition)
            binding.card.visibility = View.VISIBLE
            binding.fabScrim.visibility = View.VISIBLE
            binding.floatingActionButton.visibility = View.INVISIBLE
        }

        binding.fabScrim.setOnClickListener {
            val transition = buildContainerTransformation()

            transition.startView = binding.card
            transition.endView = binding.floatingActionButton

            TransitionManager.beginDelayedTransition(binding.coordinator, transition)
            binding.card.visibility = View.INVISIBLE
            binding.fabScrim.visibility = View.INVISIBLE
            binding.floatingActionButton.visibility = View.VISIBLE
        }
    }

    private fun setRecyclerViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MessagesAdapter(messages)
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            /*
            // When scroll down FAB disappears, when scroll up FAB appears
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    binding.floatingActionButton.hide()
                } else {
                    binding.floatingActionButton.show()
                }
            }
            */

            // When is dragging FAB disappears, when stops FAB appears
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    binding.floatingActionButton.show()
                } else {
                    binding.floatingActionButton.hide()
                }
            }
        })

        binding.cardRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.cardRecyclerView.adapter = ContactsAdapter(favContacts)
    }

    private fun buildContainerTransformation() =
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