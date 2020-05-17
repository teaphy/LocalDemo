package com.teaphy.localdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.teaphy.localdemo.util.LocalUtil

abstract class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        val context = LocalUtil.setLocal(newBase)
        super.attachBaseContext(context)
    }
}