package com.geekbrains.githubapp.data.web

import com.geekbrains.githubapp.domain.entity.GitProject
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitApi {
    @GET("users/{user}/repos")
    fun getProjects(@Path("user") user: String): Single<List<GitProject>>
}