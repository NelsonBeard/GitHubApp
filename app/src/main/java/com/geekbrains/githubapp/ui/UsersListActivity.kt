package com.geekbrains.githubapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geekbrains.githubapp.databinding.ActivityUsersListBinding
import com.geekbrains.githubapp.ui.UsersListRecyclerView.UsersListAdapter

class UsersListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}