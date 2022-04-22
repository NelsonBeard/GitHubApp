package com.geekbrains.githubapp.ui.user_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.githubapp.domain.project.GitProject
import com.geekbrains.githubapp.domain.project.GitProjectsRepo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserProfileViewModel(
    private val gitProjectsRepo: GitProjectsRepo
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _projects = MutableLiveData<List<GitProject>>()
    val projects: LiveData<List<GitProject>> = _projects

    fun getProjects(userName: String) {
        compositeDisposable.add(
            gitProjectsRepo
                .showProjects(userName)
                .subscribeBy { _projects.postValue(it) }
        )
    }
    
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}