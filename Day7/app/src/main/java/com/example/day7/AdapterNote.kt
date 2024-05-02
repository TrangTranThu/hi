package com.example.day7

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterNote(var noteList: MutableList<Note> = mutableListOf()) :
    RecyclerView.Adapter<AdapterNote.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        val tvCreatedAt = itemView.findViewById<TextView>(R.id.txtCreatedAt)
        val tvContent = itemView.findViewById<TextView>(R.id.txtContent)
        val tvFavourite = itemView.findViewById<TextView>(R.id.txtContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.item_note, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = noteList.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tvTitle.text = noteList[position].title
        holder.tvCreatedAt.text = noteList[position].content
//        holder.tvContent.text = noteList[position].createdAt
    }
}