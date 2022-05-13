package com.geekbrains.githubapp

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.geekbrains.githubapp.di.AppDependenciesComponent
import com.geekbrains.githubapp.di.AppDependenciesModule
import com.geekbrains.githubapp.di.DaggerAppDependenciesComponent

class App : Application() {
    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()
        appDependenciesComponent = DaggerAppDependenciesComponent
            .builder()
            .appDependenciesModule(AppDependenciesModule(this))
            .build()
    }
}

val Context.app: App
    get() {
        return applicationContext as App
    }

val Fragment.app: App
    get() = requireActivity().app