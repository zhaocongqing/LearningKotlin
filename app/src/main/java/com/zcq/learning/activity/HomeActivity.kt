package com.zcq.learning.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.zcq.learning.R
import com.zcq.learning.base.BaseActivity
import com.zcq.learning.databinding.ActivityHomeBinding
import com.zcq.learning.utils.ResourceUtils
import com.zcq.learning.utils.StatusBarUtils

class HomeActivity : BaseActivity() {

    //声明binding用于视图绑定
    private lateinit var binding: ActivityHomeBinding

    //底部按钮ID
    private var ids = mutableListOf(R.id.navigation_home, R.id.navigation_category,
        R.id.navigation_found, R.id.navigation_shopping_cart, R.id.navigation_mine).toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.setStatusBarTheme(this, false)
        ResourceUtils.getColor(R.color.color_theme).let {
            StatusBarUtils.setStatusBarColor(this, it)
        }
        //初始化binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        clearBNToast(navView, ids) //清除长按吐司问题
        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        navView.setupWithNavController(navController)
    }

    /**
     * 清除BottomNavigationViewBottom长按吐司
     */
    private fun clearBNToast(bnView: BottomNavigationView, ids: MutableList<Int>){
        val btnView: ViewGroup = (bnView.getChildAt(0) as ViewGroup)
        //遍历子View,重写长按点击事件
        for (position in 0 until ids.size) {
            btnView.getChildAt(position)
                .findViewById<View>((ids[position] as Int?)!!)
                .setOnLongClickListener { true }
        }
    }
}