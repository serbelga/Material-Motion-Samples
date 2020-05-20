package com.example.sergiobelda.materialmotion.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sergiobelda.materialmotion.databinding.AlbumsFragmentBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.transition.MaterialFadeThrough

class AlbumsFragment : Fragment() {
    private var _binding: AlbumsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough.create()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AlbumsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AlbumsAdapter(albums, requireContext())
        adapter.albumClickListener = object : AlbumsAdapter.AlbumClickListener {
            override fun onAlbumClick(id: Int, cardView: MaterialCardView) {
                val extras = FragmentNavigatorExtras(
                    cardView to id.toString()
                )
                val action = AlbumsFragmentDirections.navToAlbumFragment(id)
                findNavController().navigate(action, extras)
            }
        }
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
    }
}
