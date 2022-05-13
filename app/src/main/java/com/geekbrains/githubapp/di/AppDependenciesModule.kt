package com.geekbrains.githubapp.di

import android.content.Context
import com.geekbrains.githubapp.data.web.GitApiDTO
import com.geekbrains.githubapp.data.web.RetrofitGitRepoImpl
import com.geekbrains.githubapp.domain.usecase.GitRepo
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppDependenciesModule(val context: Context) {

    @Singleton
    @Provides
    fun provideGitHubApi(retrofit: Retrofit): GitApiDTO {
        return retrofit.create(GitApiDTO::class.java)
    }

    @Singleton
    @Provides
    fun provideProjectRepo(api: GitApiDTO): GitRepo {
        return RetrofitGitRepoImpl(api)
    }

    @Provides
    @Named("api_url")
    fun provideBaseUrl(): String {
        return "https://api.github.com/"
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("api_url") baseUrl: String, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .build()
    }
}