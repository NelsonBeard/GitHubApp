package com.geekbrains.githubapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.githubapp.databinding.ActivityUsersListBinding
import com.geekbrains.githubapp.ui.UsersListRecyclerView.UsersListAdapter

class UsersListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsersListBinding
    private lateinit var viewModel: UsersListViewModel
    private val adapter = UsersListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[UsersListViewModel::class.java]
        initUsersList()
    }

    private fun initUsersList() {
        viewModel.getData().observe(this) {
            binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.usersRecyclerView.adapter = adapter
        }
    }
}