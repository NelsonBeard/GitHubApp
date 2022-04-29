package com.geekbrains.githubapp.ui.users_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.githubapp.data.mock.MockUsersRepoImpl
import com.geekbrains.githubapp.domain.entity.User

class UsersListViewModel : ViewModel() {

    private var users: MutableLiveData<List<User>> = MutableLiveData()

    fun getData(): LiveData<List<User>> {
        users.value = MockUsersRepoImpl().getUsersList()
        return users
    }
}