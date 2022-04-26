package com.geekbrains.githubapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.geekbrains.githubapp.databinding.ActivityMainBinding
import com.geekbrains.githubapp.ui.users_list.UsersListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(binding.mainContainerLayout.id, UsersListFragment.newInstance())
            .commit()
    }
}