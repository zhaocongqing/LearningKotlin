package com.zcq.learning.base
import android.annotation.SuppressLint
import android.content.Context
import androidx.multidex.MultiDexApplication

/**
 * Create by zcq at 5/15/22
 */
class App : MultiDexApplication() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var mContext: Context
        @SuppressLint("StaticFieldLeak")
        private lateinit var mInstance: App
    }

    override fun onCreate() {
        super.onCreate()
        setTheme(applicationInfo.theme)
        mContext = this.applicationContext
        mInstance = this
    }

    fun getContext(): Context {
       return mContext
    }

    fun getInstance(): App {
        return mInstance
    }
}