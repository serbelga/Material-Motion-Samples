package com.example.sergiobelda.materialmotion.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.WelcomeFragmentBinding
import com.google.android.material.transition.MaterialSharedAxis

class WelcomeFragment : Fragment() {
    private var _binding: WelcomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            val fragment = SignInFragment()
            fragment.enterTransition = MaterialSharedAxis.create(MaterialSharedAxis.Z, false)
            parentFragmentManager.commit {
                replace(R.id.fragment_container, fragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "WelcomeFragment"
    }
}