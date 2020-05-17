package com.teaphy.localdemo.application

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.teaphy.localdemo.util.LocalUtil

class LocalApplication : Application() {

    override fun attachBaseContext(base: Context) {
        val context = LocalUtil.setLocal(base)

        super.attachBaseContext(context)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocalUtil.setLocal(this)
    }
}