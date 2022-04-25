package com.geekbrains.githubapp.data.mock

import com.geekbrains.githubapp.domain.entity.User
import com.geekbrains.githubapp.domain.usecase.UsersRepo

class MockUsersRepoImpl : UsersRepo {
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