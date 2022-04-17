package com.geekbrains.githubapp.data

import com.geekbrains.githubapp.domain.User
import com.geekbrains.githubapp.domain.UsersRepo

class MockUsersRepoImpl: UsersRepo{
    override fun getUsersList(): List<User> {
        return listOf(
            User("Ben Askren"),
            User("Khamzat Chimaev"),
            User("Gilbert Burns"),
            User("Diego Sanchez"),
            User("Max Holloway"),
            User("Dustin Porier"),
            User("Justin Gaetje"),
            User("Petr Yan"),
            User("Jorge Masvidal"),
            User("Jiri Prochazka"),
        )
    }
}