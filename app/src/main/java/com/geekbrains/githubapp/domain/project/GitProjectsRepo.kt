package com.geekbrains.githubapp.domain.project

import io.reactivex.rxjava3.core.Single

interface GitProjectsRepo {
    fun showProjects(userName: String): Single<List<GitProject>>
}