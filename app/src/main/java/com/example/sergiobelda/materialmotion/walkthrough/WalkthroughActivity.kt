package com.example.sergiobelda.materialmotion.walkthrough

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.WalkthroughActivityBinding
import com.google.android.material.transition.MaterialSharedAxis

private const val COUNT = 3

class WalkthroughActivity : AppCompatActivity() {
    private lateinit var binding: WalkthroughActivityBinding
    private var selected = MutableLiveData<Int>().apply {
        value = 0
    }
    private val titles by lazy {
        arrayListOf(
            getString(R.string.upload_your_photos),
            getString(R.string.share),
            getString(R.string.invite_friends)
        )
    }
    private val bodies by lazy {
        arrayListOf(
            getString(R.string.upload_artistic_photos),
            getString(R.string.share_work_social_networks),
            getString(R.string.enjoy_rewards)
        )
    }
    private val images = arrayListOf(
        R.drawable.undraw_drag,
        R.drawable.undraw_social_sharing,
        R.drawable.undraw_winners
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WalkthroughActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selected.value?.let {
            val fragment = WalkthroughFragment.newInstance(
                titles[it],
                bodies[it],
                images[it]
            )
            supportFragmentManager.commit {
                add(R.id.fragment_container, fragment, FRAGMENT_TAG)
            }
        }

        setDotsTabLayout()
        setClickListeners()
        setSelectedObserver()
    }

    private fun setDotsTabLayout() {
        repeat(COUNT) {
            binding.tabLayout.addTab(binding.tabLayout.newTab())
        }
        binding.tabLayout.touchables.forEach { it.isEnabled = false }
    }

    private fun setClickListeners() {
        binding.backButton.setOnClickListener {
            selected.value?.let {
                selected.value = it - 1
            }
            selectFragment(forward = false)
        }
        binding.nextButton.setOnClickListener {
            selected.value?.let {
                selected.value = it + 1
            }
            selectFragment(forward = true)
        }
    }

    private fun setSelectedObserver() {
        selected.observe(this, Observer {
            binding.nextButton.isEnabled = it < COUNT - 1
            binding.backButton.isEnabled = it > 0
            binding.tabLayout.apply {
                selectTab(getTabAt(it))
            }
        })
    }

    private fun selectFragment(forward: Boolean) {
        selected.value?.let {
            val previousFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG)
            previousFragment?.exitTransition = buildTransition(forward)
            val fragment = WalkthroughFragment.newInstance(
                titles[it],
                bodies[it],
                images[it]
            )
            fragment.enterTransition = buildTransition(forward)
            supportFragmentManager.commit {
                replace(R.id.fragment_container, fragment, FRAGMENT_TAG)
            }
        }
    }

    private fun buildTransition(forward: Boolean) =
        MaterialSharedAxis(MaterialSharedAxis.X, forward).apply {
            duration = 500
        }

    companion object {
        private const val FRAGMENT_TAG = "WALKTHROUGH_FRAGMENT"
    }
}
