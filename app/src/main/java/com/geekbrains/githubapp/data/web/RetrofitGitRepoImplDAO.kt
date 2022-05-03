package com.geekbrains.githubapp.data.web

import com.geekbrains.githubapp.domain.entity.GitAvatar
import com.geekbrains.githubapp.domain.entity.GitProject
import com.geekbrains.githubapp.domain.usecase.GitRepo
import io.reactivex.rxjava3.core.Single

class RetrofitGitRepoImpl(
    private val api: GitApiDTO
) : GitRepo {
    override fun showProjects(userName: String): Single<List<GitProject>> {
        return api.getProjects(userName)
    }

    override fun showAvatar(userName: String): Single<GitAvatar> {
        return api.getAvatar(userName)
    }
}