package com.vinaymj.simplenewsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by vinaymj on 06/10/22.
 */
@HiltAndroidApp
class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}