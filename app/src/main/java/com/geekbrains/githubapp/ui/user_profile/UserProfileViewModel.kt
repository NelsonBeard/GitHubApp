package com.geekbrains.githubapp.ui.user_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.githubapp.domain.entity.GitAvatar
import com.geekbrains.githubapp.domain.entity.GitProject
import com.geekbrains.githubapp.domain.usecase.GitRepo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserProfileViewModel(
    private val gitProjectsRepo: GitRepo
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _projects = MutableLiveData<List<GitProject>>()
    val projects: LiveData<List<GitProject>> = _projects

    private val _avatar = MutableLiveData<GitAvatar>()
    val avatar: LiveData<GitAvatar> = _avatar

    fun getProjects(userName: String) {
        compositeDisposable.add(
            gitProjectsRepo
                .showProjects(userName)
                .subscribeBy { _projects.postValue(it) }
        )
    }

    fun getAvatar(userName: String) {
        compositeDisposable.add(
            gitProjectsRepo
                .showAvatar(userName)
                .subscribeBy { _avatar.postValue(it) }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}