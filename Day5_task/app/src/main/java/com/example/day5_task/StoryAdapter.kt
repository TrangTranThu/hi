package com.example.day5_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoryAdapter(var storyList: MutableList<Account>) :
    RecyclerView.Adapter<StoryAdapter.storyViewHolder>() {
    class storyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgStory = itemView.findViewById<ImageView>(R.id.imgstory)
        var txtname = itemView.findViewById<TextView>(R.id.txt_nameaccstory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): storyViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_story, parent, false)
        return storyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    override fun onBindViewHolder(holder: storyViewHolder, position: Int) {
        var newList = storyList[position]
        holder.txtname.text = newList.name
    }
}