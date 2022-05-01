package com.geekbrains.githubapp.data.web

import com.geekbrains.githubapp.domain.entity.GitProject
import com.geekbrains.githubapp.domain.usecase.GitProjectsRepo
import io.reactivex.rxjava3.core.Single

class RetrofitGitProjectsRepoImpl(
    private val api: GitApi
) : GitProjectsRepo {
    override fun showProjects(userName: String): Single<List<GitProject>> {
        return api.getProjects(userName)
    }
}