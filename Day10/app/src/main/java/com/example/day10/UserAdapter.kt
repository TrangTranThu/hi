package com.example.day10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(
    val onItemClick: (view: TextView) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var userList: MutableList<User> = mutableListOf()

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUserName = itemView.findViewById<TextView>(R.id.tvUserName)
        val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val tvAge = itemView.findViewById<TextView>(R.id.tvAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tvUserName.text = userList[position].username
        holder.tvAddress.text = userList[position].address
        holder.tvAge.text = userList[position].age.toString()

        holder.tvUserName.setOnClickListener{view ->
            onItemClick(view as TextView)
        }

    }

    fun setList(newList: MutableList<User>) {
        userList = newList
        notifyDataSetChanged()
    }
}