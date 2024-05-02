package com.example.day4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    var userList: MutableList<User> = mutableListOf()
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUserName = itemView.findViewById<TextView>(R.id.tvUserName)
        val tvEmail = itemView.findViewById<TextView>(R.id.tvAddress)
    }

//    var userList: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tvUserName.text = userList[position].userName
        holder.tvEmail.text = userList[position].userEmail

        holder.tvUserName.setOnClickListener {
            Toast.makeText(holder.tvUserName.context, "${userList[position]}", Toast.LENGTH_SHORT)
                .show()
        }
        holder.tvEmail.setOnClickListener {
            userList.removeAt(position)
            notifyDataSetChanged()
        }
    }
}