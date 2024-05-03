package com.example.day8_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteListAdapter(val noteDB: NoteRoomDatabase) :
    RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    private var notes = emptyList<Note>()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleItemView = itemView.findViewById<TextView>(R.id.tvTitle)
        val contentItemView = itemView.findViewById<TextView>(R.id.tvContent)
        val checkItemView = itemView.findViewById<CheckBox>(R.id.cbIsfav)
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
        holder.contentItemView.text = currentNote.content
//        holder.checkItemView.isChecked = currentNote.check
//
//        holder.checkItemView.setOnClickListener{
//            currentNote.check = holder.checkItemView.isChecked
//            noteDB.noteDao().getAllNotes()[position].check = currentNote.check
//        }
    }
    fun updateNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}