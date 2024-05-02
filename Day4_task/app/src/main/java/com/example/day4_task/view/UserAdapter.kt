package com.example.day4_task.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.day4_task.R
import com.example.day4_task.model.User

class UserAdapter(private val userList: MutableList<User> = mutableListOf<User>()) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img = v.findViewById<ImageView>(R.id.img)
        val name = v.findViewById<TextView>(R.id.name)
        val email = v.findViewById<TextView>(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userList[position]
        holder.name.text = "Name: " + newList.userName
        holder.email.text = "Email: " + newList.email
    }
}