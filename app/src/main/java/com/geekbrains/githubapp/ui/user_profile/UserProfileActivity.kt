package com.geekbrains.githubapp.ui.user_profile

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.githubapp.app
import com.geekbrains.githubapp.databinding.ActivityUserProfileBinding

class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding
    private val viewModel: UserProfileViewModel by viewModels { ProjectsViewModelFactory(app.gitProjectsRepo) }
    private val adapter = UserProfileAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initProfile()
    }

    private fun initProfile() {

        binding.userProfileRecyclerView.adapter = adapter

        val userName = intent.extras?.getString("NAME").toString()
        binding.userName.text = userName

        viewModel.apply {
            getProjects(userName)
            projects.observe(this@UserProfileActivity) {
                adapter.setData(it)
            }

        }
    }
}