package com.example.sergiobelda.materialmotion.music

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sergiobelda.materialmotion.R
import com.google.android.material.transition.MaterialFadeThrough

class ArtistsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        enterTransition = MaterialFadeThrough.create()
        return inflater.inflate(R.layout.artists_fragment, container, false)
    }
}