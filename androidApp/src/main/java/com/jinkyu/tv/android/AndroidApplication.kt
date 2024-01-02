package com.jinkyu.tv.android

import android.app.Application
import com.jinkyu.tv.di.initKoin

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}