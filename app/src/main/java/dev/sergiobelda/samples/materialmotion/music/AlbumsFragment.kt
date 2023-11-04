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

package dev.sergiobelda.samples.materialmotion.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.card.MaterialCardView
import com.google.android.material.transition.MaterialFadeThrough
import dev.sergiobelda.samples.materialmotion.databinding.AlbumsFragmentBinding

class AlbumsFragment : Fragment() {
    private var _binding: AlbumsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = AlbumsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        binding.recyclerView.post { startPostponedEnterTransition() }

        val adapter = AlbumsAdapter(albums, requireContext())
        adapter.albumClickListener =
            object : AlbumsAdapter.AlbumClickListener {
                override fun onAlbumClick(
                    id: Int,
                    cardView: MaterialCardView,
                ) {
                    val extras =
                        FragmentNavigatorExtras(
                            cardView to id.toString(),
                        )
                    val action = AlbumsFragmentDirections.navToAlbumFragment(id)
                    findNavController().navigate(action, extras)
                }
            }
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
    }
}
