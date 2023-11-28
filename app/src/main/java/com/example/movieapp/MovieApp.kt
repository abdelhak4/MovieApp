package com.example.movieapp

import android.app.Application
import com.example.movieapp.data.AppConainer
import com.example.movieapp.data.DefaultAppContainer

//@HiltAndroidApp
class MovieApp : Application() {
    lateinit var container: AppConainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}