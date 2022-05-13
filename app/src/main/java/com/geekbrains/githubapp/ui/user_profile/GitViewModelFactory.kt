package com.geekbrains.githubapp.ui.user_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.githubapp.domain.usecase.GitRepo

class GitViewModelFactory(private val repo: GitRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserProfileViewModel(repo) as T
    }
}