package com.jinkyu.tv.android

import android.app.Application
import com.jinkyu.tv.di.initKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}