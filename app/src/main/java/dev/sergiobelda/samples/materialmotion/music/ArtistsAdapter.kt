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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.sergiobelda.samples.materialmotion.databinding.ItemArtistBinding

class ArtistsAdapter(var items: List<Artist>) : RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = ViewHolder(
        ItemArtistBinding.inflate(
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

    inner class ViewHolder(var binding: ItemArtistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist) {
            binding.artist = artist
        }
    }
}
