package com.geekbrains.githubapp.ui.user_profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.githubapp.data.MockUsersRepoImpl
import com.geekbrains.githubapp.databinding.ActivityUserProfileBinding
import com.geekbrains.githubapp.domain.User

class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding
    private val usersList: List<User> = MockUsersRepoImpl().getUsersList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initProfile()
    }

    private fun initProfile() {
        binding.userName.text = intent.extras?.getString("NAME")
    }
}