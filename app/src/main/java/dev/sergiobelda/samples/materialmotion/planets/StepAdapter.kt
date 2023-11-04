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

package dev.sergiobelda.samples.materialmotion.planets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.sergiobelda.samples.materialmotion.databinding.ItemStepBinding

class StepAdapter(val items: List<Any>) : RecyclerView.Adapter<StepAdapter.ViewHolder>() {
    lateinit var stepClickListener: StepClickListener
    private var selected = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = ViewHolder(
        ItemStepBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) = holder.bind(position)

    inner class ViewHolder(val binding: ItemStepBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            if (position == items.size - 1) {
                binding.separator.visibility = View.GONE
            } else {
                binding.separator.visibility = View.VISIBLE
            }
            binding.stepName.isSelected = position == selected
            binding.stepButton.isSelected = position == selected
            binding.stepName.text = position.toString()
            binding.stepButton.setOnClickListener {
                val aux = selected
                selected = position
                stepClickListener.onStepClick(position)
                notifyItemChanged(aux)
                notifyItemChanged(selected)
            }
        }
    }

    interface StepClickListener {
        fun onStepClick(position: Int)
    }
}
