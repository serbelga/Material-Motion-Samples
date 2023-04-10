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

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.navigation.fragment.navArgs
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.MaterialContainerTransform
import dev.sergiobelda.samples.materialmotion.R
import dev.sergiobelda.samples.materialmotion.databinding.AlbumFragmentBinding

class AlbumFragment : Fragment() {
    private val args: AlbumFragmentArgs by navArgs()

    private lateinit var binding: AlbumFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.album_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.albumFragmentRoot.transitionName = args.albumId.toString()
        val album = albums.find { it.id == args.albumId }
        binding.album = album

        Glide.with(requireContext())
            .asBitmap()
            .load(album?.image)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    val palette = Palette.from(resource).generate()
                    palette.darkVibrantSwatch?.let {
                        binding.collapsingToolbar.setBackgroundColor(it.rgb)
                        val color = requireContext().getColor(R.color.colorOnPrimary)
                        binding.collapsingToolbar.setCollapsedTitleTextColor(color)
                        binding.collapsingToolbar.setExpandedTitleColor(color)
                    } ?: palette.lightVibrantSwatch?.let {
                        binding.collapsingToolbar.setBackgroundColor(it.rgb)
                    }
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = buildContainerTransform(true)
        sharedElementReturnTransition = buildContainerTransform(false)
    }

    private fun buildContainerTransform(entering: Boolean) =
        MaterialContainerTransform(requireContext(), entering).apply {
            drawingViewId = R.id.nav_host_fragment
            interpolator = FastOutSlowInInterpolator()
            containerColor = MaterialColors.getColor(
                requireActivity().findViewById(android.R.id.content),
                R.attr.colorSurface,
            )
            fadeMode = MaterialContainerTransform.FADE_MODE_OUT
            duration = 300
        }
}
