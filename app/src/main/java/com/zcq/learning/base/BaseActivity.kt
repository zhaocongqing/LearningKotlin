package com.zcq.learning.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Create by zcq on 5/31/22 1:48 PM
 */
abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置状态栏背景色
        //添加水印
    }
}