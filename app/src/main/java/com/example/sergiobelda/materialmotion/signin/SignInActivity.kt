package com.example.sergiobelda.materialmotion.signin

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.SignInActivityBinding
import com.google.android.material.transition.MaterialSharedAxis


class SignInActivity : AppCompatActivity() {
    private lateinit var binding: SignInActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        super.onCreate(savedInstanceState)
        binding = SignInActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = SignInFragment()
        fragment.enterTransition = MaterialSharedAxis.create(MaterialSharedAxis.Z, false)
        supportFragmentManager.commit {
            add(R.id.fragment_container, fragment)
        }
    }
}