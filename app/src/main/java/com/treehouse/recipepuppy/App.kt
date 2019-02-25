package com.treehouse.recipepuppy

import android.app.Application
import com.treehouse.recipepuppy.di.AppComponent
import com.treehouse.recipepuppy.di.DaggerAppComponent


class App: Application(){
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()

    }
    fun getComponent()=appComponent
}