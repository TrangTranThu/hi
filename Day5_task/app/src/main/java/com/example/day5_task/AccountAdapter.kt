package com.example.day5_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AccountAdapter(var postlist: MutableList<Account>) :
    RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {
    class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.txt_name_acc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.item_list, parent, false)
        return AccountViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val newList = postlist[position]
        holder.txtName.text = newList.name
    }
}