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

package dev.sergiobelda.materialmotionsamples.planets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dev.sergiobelda.materialmotionsamples.R
import dev.sergiobelda.materialmotionsamples.databinding.PlanetFragmentBinding

private const val ARG_PLANET_ID = "planet_id"

/**
 * A simple [Fragment] subclass.
 * Use the [PlanetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlanetFragment : Fragment() {
    private lateinit var binding: PlanetFragmentBinding

    private var planetId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            planetId = it.getInt(ARG_PLANET_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.planet_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planet = planets.singleOrNull { it.id == planetId }
        planet?.let {
            binding.planet = it
        }
    }

    companion object {
        /**
         * @param planetId
         * @return A new instance of fragment StepFragment.
         */
        @JvmStatic
        fun newInstance(planetId: Int) =
            PlanetFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PLANET_ID, planetId)
                }
            }
    }
}
