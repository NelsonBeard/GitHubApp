package com.geekbrains.githubapp.data.web

import com.geekbrains.githubapp.domain.entity.GitProject
import com.geekbrains.githubapp.domain.usecase.GitProjectsRepo
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGitProjectsRepoImplDAO : GitProjectsRepo {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: GitApiDTO = retrofit.create(GitApiDTO::class.java)

    override fun showProjects(userName: String): Single<List<GitProject>> {
        return api.getProjects(userName)
    }
}