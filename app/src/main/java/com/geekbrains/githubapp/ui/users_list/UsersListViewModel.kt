package com.geekbrains.githubapp.ui.users_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.githubapp.data.mock.MockUsersRepoImplDAO
import com.geekbrains.githubapp.domain.entity.User

class UsersListViewModel(
    private val liveDataForViewToObserve: MutableLiveData<List<User>> = MutableLiveData()
) : ViewModel() {
    fun getData(): LiveData<List<User>> {
        liveDataForViewToObserve.value = MockUsersRepoImplDAO().getUsersList()
        return liveDataForViewToObserve
    }
}