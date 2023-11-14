package com.example.tbc_academy_android_task_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tbc_academy_android_task_8.databinding.ActivityMainBinding
import com.example.tbc_academy_android_task_8.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        val email = intent.getStringExtra("email")
        val name = intent.getStringExtra("name")
        val lastName = intent.getStringExtra("lastname")

        binding.tvEmailValue.text = email
        binding.tvNameValue.text = name
        binding.tvLastNameValue.text = lastName

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}