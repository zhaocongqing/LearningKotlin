package com.zcq.learning.utils

import android.graphics.drawable.Drawable
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import com.zcq.learning.base.App


/**
 * @Describe 资源文件读取工具类
 *
 * @Author cq.zhao
 * @CreationTime 2023/1/29 14:37
 */
object ResourceUtils {

    fun getDrawable(id: Int): Drawable? {
        return App().getInstance()?.let {
            ResourcesCompat.getDrawable(
                it.resources,
                id,
                it.theme
            )
        }
    }

    fun getColor(id: Int): Int? {
        return App().getInstance()?.let {
            ResourcesCompat.getColor(
                it.resources,
                id,
                it.theme
            )
        }
    }

    fun getString(@StringRes id: Int): String? {
        return App().getInstance()?.resources?.getString(id)
    }

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String? {
        return App().getInstance()?.resources?.getString(id, *formatArgs)
    }

    fun getDimen(id: Int): Int? {
        return App().getInstance()?.resources?.getDimensionPixelOffset(id)
    }
}