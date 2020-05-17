package com.teaphy.localdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teaphy.localdemo.util.LocalUtil
import com.teaphy.localdemo.util.SPUtil
import kotlinx.android.synthetic.main.activity_local.*

class LocalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local)

        setListener()
    }

    private fun setListener() {
        btnChina.setOnClickListener {
            saveLocal(0)
        }

        btnEnglish.setOnClickListener {
            saveLocal(1)
        }

        btnJapan.setOnClickListener {
            saveLocal(2)
        }
    }

    private fun saveLocal(localCode: Int) {
        LocalUtil.saveSelectLanguage(this, localCode)

        //重启app,这一步一定要加上，如果不重启app，可能打开新的页面显示的语言会不正确
        val intent =  Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
