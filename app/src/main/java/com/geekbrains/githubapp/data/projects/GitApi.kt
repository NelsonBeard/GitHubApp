package com.geekbrains.githubapp.data.projects

import com.geekbrains.githubapp.domain.project.GitProject
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitApi {
    @GET("users/{user}/repos")
    fun getProjects(@Path("user") user: String): Single<List<GitProject>>
}