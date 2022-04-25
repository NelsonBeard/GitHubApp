package com.geekbrains.githubapp.domain.usecase

import com.geekbrains.githubapp.domain.entity.GitProject
import io.reactivex.rxjava3.core.Single

interface GitProjectsRepo {
    fun showProjects(userName: String): Single<List<GitProject>>
}