package com.geekbrains.githubapp.di

import com.geekbrains.githubapp.data.web.GitApiDTO
import com.geekbrains.githubapp.data.web.RetrofitGitRepoImpl
import com.geekbrains.githubapp.domain.usecase.GitRepo
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

    single<GitRepo> { RetrofitGitRepoImpl(get()) }
    single<GitApiDTO> { get<Retrofit>().create(GitApiDTO::class.java) }
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
