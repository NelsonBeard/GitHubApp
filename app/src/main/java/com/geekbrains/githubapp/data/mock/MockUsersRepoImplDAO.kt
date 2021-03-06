package com.geekbrains.githubapp.data.mock

import com.geekbrains.githubapp.domain.entity.User
import com.geekbrains.githubapp.domain.usecase.UsersRepo

class MockUsersRepoImplDAO : UsersRepo {
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

    fun usersCounter(): Int {
        return getUsersList().size
    }

    fun getFirstUserName():String{
        return getUsersList()[0].userName
    }
}