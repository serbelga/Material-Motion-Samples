package com.example.sergiobelda.materialmotion.planets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.sergiobelda.materialmotion.databinding.PlanetFragmentBinding

private const val ARG_PLANET_ID = "planet_id"

/**
 * A simple [Fragment] subclass.
 * Use the [PlanetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlanetFragment : Fragment() {
    private var _binding: PlanetFragmentBinding? = null
    private val binding get() = _binding!!

    private var planetId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            planetId = it.getInt(ARG_PLANET_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PlanetFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planet = planets.singleOrNull { it.id == planetId}
        planet?.let {
            Glide.with(requireContext())
                .load(it.mainImage)
                .into(binding.mainImage)

            binding.planetName.text = planet.name
            binding.planetDescription.text = planet.description
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