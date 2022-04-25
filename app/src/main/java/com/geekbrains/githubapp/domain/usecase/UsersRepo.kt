package com.geekbrains.githubapp.domain.usecase

import com.geekbrains.githubapp.domain.entity.User

interface UsersRepo {
    fun getUsersList(): List<User>
}