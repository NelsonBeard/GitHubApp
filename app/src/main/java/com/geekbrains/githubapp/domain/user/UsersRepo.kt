package com.geekbrains.githubapp.domain.user

interface UsersRepo {
    fun getUsersList() : List<User>
}