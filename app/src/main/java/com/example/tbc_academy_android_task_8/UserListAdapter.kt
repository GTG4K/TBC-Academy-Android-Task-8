package com.example.tbc_academy_android_task_8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_academy_android_task_8.databinding.UserItemBinding

class UserListAdapter(var users: List<User>) :
    RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    var UserListAdapterEvents: UserListAdapterEvents? = null
    private var userList: MutableList<User> = users as MutableList<User>

    inner class UserListViewHolder(val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnDelete.setOnClickListener {
                val position = adapterPosition
                deleteItem(position)
            }
        }
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

    fun deleteItem(position: Int) {
        userList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int = users.size

}