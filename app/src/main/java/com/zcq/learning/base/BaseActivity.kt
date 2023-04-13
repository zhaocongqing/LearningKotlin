package com.zcq.learning.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zcq.learning.R
import com.zcq.learning.utils.ResourceUtils
import com.zcq.learning.utils.StatusBarUtils

/**
 * Create by zcq on 5/31/22 1:48 PM
 */
abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置状态栏背景色
        initStatusBar()
    }

    /**
     * 设置标题栏颜色
     */
    private fun initStatusBar() {
        StatusBarUtils.setStatusBarTheme(this, true)
        ResourceUtils.getColor(R.color.white)?.let { StatusBarUtils.setStatusBarColor(this, it) }
    }
}