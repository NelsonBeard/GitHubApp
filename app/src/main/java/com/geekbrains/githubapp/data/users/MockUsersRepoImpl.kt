package com.geekbrains.githubapp.data.users

import com.geekbrains.githubapp.domain.user.User
import com.geekbrains.githubapp.domain.user.UsersRepo

class MockUsersRepoImpl: UsersRepo {
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
            User("NelsonBeard"),
            User("DumDumbIchGB"),
            User("borhammere")
        )
    }
}