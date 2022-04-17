package com.geekbrains.githubapp.domain

interface UsersRepo {
    fun getUsersList() : List<User>
}