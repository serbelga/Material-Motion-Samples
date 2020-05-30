package com.example.sergiobelda.materialmotion.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.SignInFragmentBinding
import com.google.android.material.transition.MaterialSharedAxis

class SignInFragment : Fragment() {
    private var _binding: SignInFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = buildTransition()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignInFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signIn.setOnClickListener {
            val welcomeFragment = WelcomeFragment()
            welcomeFragment.enterTransition = buildTransition()
            parentFragmentManager.commit {
                replace(R.id.fragment_container, welcomeFragment)
            }
        }
    }

    private fun buildTransition() =
        MaterialSharedAxis(MaterialSharedAxis.Z, true).apply {
            duration = 500
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
