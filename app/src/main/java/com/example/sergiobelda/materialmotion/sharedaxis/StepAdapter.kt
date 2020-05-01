package com.example.sergiobelda.materialmotion.sharedaxis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sergiobelda.materialmotion.databinding.ItemStepBinding

class StepAdapter(val items: List<Any>) : RecyclerView.Adapter<StepAdapter.ViewHolder>() {
    lateinit var stepClickListener: StepClickListener
    private var selected = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemStepBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    inner class ViewHolder(val binding: ItemStepBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            position: Int
        ) {
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