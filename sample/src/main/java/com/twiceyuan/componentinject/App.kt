package com.twiceyuan.componentinject

import android.app.Application
import com.twiceyuan.componentinject.di.initKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
