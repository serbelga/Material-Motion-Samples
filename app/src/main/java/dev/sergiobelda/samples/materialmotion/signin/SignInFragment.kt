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

package dev.sergiobelda.samples.materialmotion.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.transition.MaterialSharedAxis
import dev.sergiobelda.samples.materialmotion.R
import dev.sergiobelda.samples.materialmotion.databinding.SignInFragmentBinding

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
        savedInstanceState: Bundle?,
    ): View {
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
