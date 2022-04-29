package com.geekbrains.githubapp

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.geekbrains.githubapp.data.web.RetrofitGitProjectsRepoImpl
import com.geekbrains.githubapp.di.appModule
import com.geekbrains.githubapp.domain.usecase.GitProjectsRepo
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}

