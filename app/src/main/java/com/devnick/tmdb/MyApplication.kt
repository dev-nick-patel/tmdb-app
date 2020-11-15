package com.devnick.tmdb

import android.app.Application
import com.devnick.tmdb.util.InternetUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        InternetUtil.init(this)
    }
//    companion object {
//        const val API_KEY: String = "b4345ee566f8c05e759c6eb34e58f75b"
//    }
}