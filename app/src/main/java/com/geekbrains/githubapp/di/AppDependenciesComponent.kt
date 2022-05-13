package com.geekbrains.githubapp.di

import com.geekbrains.githubapp.domain.usecase.GitRepo
import com.geekbrains.githubapp.ui.user_profile.UserProfileFragment
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppDependenciesModule::class
    ]
)

interface AppDependenciesComponent {
    fun inject(userProfileFragment: UserProfileFragment)
    fun getProjectsRepo(): GitRepo
}