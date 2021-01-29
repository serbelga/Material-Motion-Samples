package com.example.sergiobelda.materialmotion.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sergiobelda.materialmotion.databinding.ItemSampleBinding

class SamplesAdapter(private val items: List<SampleItem>) :
    RecyclerView.Adapter<SamplesAdapter.ViewHolder>() {

    var listener: OnSampleClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemSampleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: ItemSampleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sampleItem: SampleItem) {
            binding.sample = sampleItem
            binding.button.setOnClickListener {
                listener?.onSampleClick(sampleItem)
            }
        }
    }

    interface OnSampleClickListener {
        fun onSampleClick(sampleItem: SampleItem)
    }
}
