package com.geekbrains.githubapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.githubapp.data.MockUsersRepoImpl
import com.geekbrains.githubapp.domain.User

class UsersListViewModel(
    private val liveDataForViewToObserve: MutableLiveData<List<User>> = MutableLiveData()
) : ViewModel() {

    fun getData(): LiveData<List<User>>{
        liveDataForViewToObserve.value = MockUsersRepoImpl().getUsersList()
        return liveDataForViewToObserve
    }

}