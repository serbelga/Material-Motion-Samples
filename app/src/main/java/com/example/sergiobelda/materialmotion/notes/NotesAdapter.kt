package com.example.sergiobelda.materialmotion.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sergiobelda.materialmotion.databinding.ItemNoteBinding
import com.google.android.material.card.MaterialCardView

class NotesAdapter(private val items: List<Note>) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    lateinit var noteClickListener: NoteClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.note = note
            binding.noteCard.transitionName = note.id.toString()
            binding.noteCard.setOnClickListener {
                noteClickListener.onNoteClick(note.id, binding.noteCard)
            }
        }
    }

    interface NoteClickListener {
        fun onNoteClick(id: Int, noteCard: MaterialCardView)
    }
}
