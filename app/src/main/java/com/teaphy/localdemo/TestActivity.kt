package com.teaphy.localdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.PopupWindow
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        btnPop.setOnClickListener {
            showPopu()
        }
    }

    private fun showPopu() {
        val view = LayoutInflater.from(this).inflate(R.layout.popu_text, null, false)
        val popu = PopupWindow(view, 360,360)
        popu.showAsDropDown(btnPop)
    }
}
