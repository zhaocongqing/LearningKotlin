package com.zcq.learning.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zcq.learning.R
import com.zcq.learning.utils.ResourceUtils
import com.zcq.learning.utils.StatusBarUtils
import com.zcq.learning.utils.UiKit

/**
 * Create by zcq on 5/31/22 1:48 PM
 */
abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置状态栏背景色
        initStatusBar()
    }

    protected open fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    protected open fun showToast(resId: Int) {
        showToast(getString(resId))
    }

    protected open fun showLongToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    protected open fun showLongToast(resId: Int) {
        showLongToast(getString(resId))
    }

    /**
     * 设置标题栏颜色
     */
    private fun initStatusBar() {
        StatusBarUtils.setStatusBarTheme(this, true)
        ResourceUtils.getColor(R.color.white).let { StatusBarUtils.setStatusBarColor(this, it) }
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        // 保持App字体大小不跟随系统设置改变
        if (Build.VERSION.SDK_INT < 25) {
            UiKit.keepFontScaleBeforeApi25(newBase.resources)
        } else {
            UiKit.keepFontScaleApi17(this, newBase.resources.configuration)
        }
    }
}