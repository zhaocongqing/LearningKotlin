package com.zcq.learning.base
import android.content.Context
import androidx.multidex.MultiDexApplication

/**
 * @Describe
 *
 * @Author cq.zhao
 * @CreationTime 2023/1/29 14:27
 */
class App : MultiDexApplication() {

    private var mContext: Context? = null
    private var mInstance: App? = null

    override fun onCreate() {
        super.onCreate()
        setTheme(applicationInfo.theme)
        mContext = applicationContext
        mInstance = this
    }

    fun getContext(): Context? {
        return mContext
    }

    fun getInstance(): App? {
        if (mInstance == null) {
            mInstance = App()
        }
        return mInstance
    }

}