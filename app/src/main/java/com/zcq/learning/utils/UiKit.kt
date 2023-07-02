package com.zcq.learning.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.view.WindowManager

/**
 * @author congqing.zhao(1207166)
 * @date 2023/6/25 10:14
 * @desc This is ...
 */
object UiKit {

    /**
     * 保持App字体大小不跟随系统设置改变
     */
    fun keepFontScaleBeforeApi25(resources: Resources) {
        val config = resources.configuration
        config.fontScale = 1.0f
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    /**
     * 保持App字体大小不跟随系统设置改变
     */
    fun keepFontScaleApi17(activity: Activity, config: Configuration) {
        if (config.fontScale != 1.0f) {
            config.fontScale = 1.0f
            val metrics = activity.resources.displayMetrics
            val manager = activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            manager.defaultDisplay.getMetrics(metrics)
            metrics.scaledDensity = config.fontScale * metrics.density
            activity.resources.updateConfiguration(config, metrics)
        }
    }
}