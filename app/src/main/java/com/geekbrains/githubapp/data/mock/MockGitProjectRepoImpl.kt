package com.geekbrains.githubapp.data.mock

import com.geekbrains.githubapp.domain.entity.GitProject
import com.geekbrains.githubapp.domain.usecase.GitProjectsRepo
import io.reactivex.rxjava3.core.Single

class MockGitProjectRepoImpl: GitProjectsRepo {
    override fun showProjects(userName: String): Single<List<GitProject>> {
        val mockReposList = listOf(
            GitProject("repo 1"),
            GitProject("repo 2"),
            GitProject("repo 3"),
            GitProject("repo 4"),
            GitProject("repo 5"),
            GitProject("repo 6")
        )
        return Single.just(mockReposList)
    }
}