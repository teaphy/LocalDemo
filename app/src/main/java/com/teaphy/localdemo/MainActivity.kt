package com.teaphy.localdemo

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.teaphy.localdemo.util.LocalUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDefaultLanguage()

        setListener()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        initDefaultLanguage()
    }

    private fun initDefaultLanguage() {

        Log.e("teaphy", "selectLanguage: ${LocalUtil.getSelectLanguage(this)}")

        textLocal.text = getString(R.string.current_language,
            LocalUtil.getSelectLanguage(this)
        )
    }

    private fun setListener() {
        btnTestPage.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }

        btnLocal.setOnClickListener {
            startActivity(Intent(this, LocalActivity::class.java))
        }

        btnSetting.setOnClickListener{
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        }
    }
}
