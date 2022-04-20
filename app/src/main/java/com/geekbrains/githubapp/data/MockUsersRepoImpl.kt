package com.geekbrains.githubapp.data

import com.geekbrains.githubapp.domain.User
import com.geekbrains.githubapp.domain.UsersRepo

class MockUsersRepoImpl: UsersRepo{
    override fun getUsersList(): List<User> {
        return listOf(
            User("fabpot"),
            User("andrew"),
            User("taylorotwell"),
            User("egoist"),
            User("HugoGiraudel"),
            User("ornicar"),
            User("bebraw"),
            User("nelsonic"),
            User("alexcrichton"),
            User("jonathanong"),
        )
    }
}