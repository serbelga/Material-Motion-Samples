package com.example.sergiobelda.materialmotion.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sergiobelda.materialmotion.R
import com.google.android.material.transition.MaterialSharedAxis

class WelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        enterTransition = MaterialSharedAxis.create(MaterialSharedAxis.Z, true)
        return inflater.inflate(R.layout.welcome_fragment, container, false)
    }

    companion object {
        const val TAG = "WelcomeFragment"
    }
}