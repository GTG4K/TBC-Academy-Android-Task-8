package com.example.tbc_academy_android_task_8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_academy_android_task_8.databinding.UserItemBinding

class UserListAdapter(var users: List<User>) :
    RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {
    inner class UserListViewHolder(val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(layoutInflater, parent, false)
        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.binding.apply {
            tvNameValue.text = users[position].name
            tvLastNameValue.text = users[position].lastName
            tvEmailValue.text = users[position].email
        }
    }

    override fun getItemCount(): Int = users.size

}