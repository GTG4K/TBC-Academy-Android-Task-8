package com.example.tbc_academy_android_task_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tbc_academy_android_task_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserListAdapter
    private var users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        users.add(User("giorgi", "tarkhnishvili", "tarkhna@gmail.com"))
        adapter = UserListAdapter(this, users)
        binding.rvUserList.adapter = adapter

        binding.btnAddUser.setOnClickListener {
            if (!inputsAreValid()) {
                binding.tvError.text = getString(R.string.please_fill_every_field)
            } else {
                binding.tvError.text = ""
                val user = User(
                    binding.etName.text.toString(),
                    binding.etLastName.text.toString(),
                    binding.etEmail.text.toString()
                )
                users.add(user)
                adapter.notifyItemInserted(users.size - 1)
            }

        }
    }

    private fun inputsAreValid(): Boolean {
        return binding.etName.text.toString().trim().isNotEmpty() &&
                binding.etLastName.text.toString().trim().isNotEmpty() &&
                binding.etEmail.text.toString().trim().isNotEmpty()

    }
}