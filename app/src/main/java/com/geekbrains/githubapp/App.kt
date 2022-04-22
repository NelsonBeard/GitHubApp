package com.geekbrains.githubapp

import android.app.Application
import android.content.Context
import com.geekbrains.githubapp.data.projects.RetrofitGitProjectsRepoImpl
import com.geekbrains.githubapp.domain.project.GitProjectsRepo

class App : Application() {
    val gitProjectsRepo: GitProjectsRepo by lazy { RetrofitGitProjectsRepoImpl() }
}

val Context.app: App
    get() = applicationContext as App