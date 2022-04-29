package com.geekbrains.githubapp.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geekbrains.githubapp.data.web.GitApi
import com.geekbrains.githubapp.data.web.RetrofitGitProjectsRepoImpl
import com.geekbrains.githubapp.domain.usecase.GitProjectsRepo
import com.geekbrains.githubapp.ui.user_profile.UserProfileViewModel
import com.geekbrains.githubapp.ui.users_list.UsersListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private var baseUrl = "https://api.github.com/"

val appModule = module {

    single<GitProjectsRepo> { RetrofitGitProjectsRepoImpl(get()) }
    single<GitApi> { get<Retrofit>().create(GitApi::class.java) }
    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(get())
            .build()
    }
    factory<Converter.Factory> { GsonConverterFactory.create() }
    viewModel { UserProfileViewModel(get()) }
    viewModel { UsersListViewModel() }
}
