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

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.card.MaterialCardView
import dev.sergiobelda.samples.materialmotion.R
import dev.sergiobelda.samples.materialmotion.databinding.ItemAlbumBinding

class AlbumsAdapter(private val items: List<Album>, private val context: Context) :
    RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {
    lateinit var albumClickListener: AlbumClickListener

    inner class ViewHolder(val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.album = album
            Glide.with(context)
                .asBitmap()
                .load(album.image)
                .into(
                    object : CustomTarget<Bitmap>() {
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?,
                        ) {
                            val palette = Palette.from(resource).generate()
                            palette.darkVibrantSwatch?.let {
                                binding.albumCard.setCardBackgroundColor(it.rgb)
                                val color = context.getColor(R.color.colorOnPrimary)
                                binding.albumName.setTextColor(color)
                            } ?: palette.lightVibrantSwatch?.let {
                                binding.albumCard.setCardBackgroundColor(it.rgb)
                            }
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {}
                    },
                )
            binding.albumCard.transitionName = album.id.toString()
            binding.albumCard.setOnClickListener {
                albumClickListener.onAlbumClick(album.id, binding.albumCard)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = ViewHolder(
        ItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) = holder.bind(items[position])

    interface AlbumClickListener {
        fun onAlbumClick(
            id: Int,
            cardView: MaterialCardView,
        )
    }
}
