package com.geekbrains.githubapp.domain.usecase

import com.geekbrains.githubapp.domain.entity.GitAvatar
import com.geekbrains.githubapp.domain.entity.GitProject
import io.reactivex.rxjava3.core.Single

interface GitRepo {
    fun showProjects(userName: String): Single<List<GitProject>>
    fun showAvatar(userName: String): Single<GitAvatar>
}