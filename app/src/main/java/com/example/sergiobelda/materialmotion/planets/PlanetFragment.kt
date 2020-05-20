package com.example.sergiobelda.materialmotion.planets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.databinding.PlanetFragmentBinding

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
        savedInstanceState: Bundle?
    ): View? {
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
