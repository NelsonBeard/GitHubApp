package com.geekbrains.githubapp.ui.user_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.githubapp.domain.project.GitProjectsRepo

class ProjectsViewModelFactory(private val repo: GitProjectsRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserProfileViewModel(repo) as T
    }
}