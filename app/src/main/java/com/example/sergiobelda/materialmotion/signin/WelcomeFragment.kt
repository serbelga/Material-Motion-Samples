package com.example.sergiobelda.materialmotion.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.WelcomeFragmentBinding
import com.google.android.material.transition.MaterialSharedAxis

class WelcomeFragment : Fragment() {
    private var _binding: WelcomeFragmentBinding? = null
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
        _binding = WelcomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.returnButton.setOnClickListener {
            val signInFragment = SignInFragment()
            signInFragment.enterTransition = buildTransition()
            parentFragmentManager.commit {
                replace(R.id.fragment_container, signInFragment)
            }
        }
    }

    private fun buildTransition() =
        MaterialSharedAxis(MaterialSharedAxis.Z, false).apply {
            duration = 500
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "WelcomeFragment"
    }
}
