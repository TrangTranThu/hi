package com.example.mvvc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(var notes: MutableList<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleItemView = itemView.findViewById<TextView>(R.id.tvTitle)
        val createAtItemView = itemView.findViewById<TextView>(R.id.tvCreateAt)
        val contentItemView = itemView.findViewById<TextView>(R.id.tvContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes[position]

        holder.titleItemView.text = currentNote.title
        holder.createAtItemView.text = currentNote.createAt
        holder.contentItemView.text = currentNote.content
    }
//    fun updateNotes(notes: List<Note>) {
//        this.notes = notes
//        notifyDataSetChanged()
//    }
}