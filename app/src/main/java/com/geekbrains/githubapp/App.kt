package com.geekbrains.githubapp

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.geekbrains.githubapp.data.web.RetrofitGitProjectsRepoImpl
import com.geekbrains.githubapp.domain.usecase.GitProjectsRepo

class App : Application() {
    val gitProjectsRepo: GitProjectsRepo by lazy { RetrofitGitProjectsRepoImpl() }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app