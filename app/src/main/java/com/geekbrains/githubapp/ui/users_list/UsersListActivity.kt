package com.geekbrains.githubapp.ui.users_list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.githubapp.databinding.ActivityUsersListBinding
import com.geekbrains.githubapp.ui.user_profile.UserProfileActivity

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

        adapter.listener = UsersListAdapter.OnItemClick { user ->
            val intent = Intent(this, UserProfileActivity::class.java)
            intent.putExtra("NAME", user.name)
            startActivity(intent)
        }
    }

    private fun initUsersList() {
        viewModel.getData().observe(this) {
            binding.usersListRecyclerView.adapter = adapter
        }
    }

}