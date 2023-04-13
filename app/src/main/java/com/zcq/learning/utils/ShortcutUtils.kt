package com.zcq.learning.utils

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.text.TextUtils
import android.util.Log
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.zcq.learning.R
import com.zcq.learning.activity.TestActivity
import com.zcq.learning.receivers.IconAddCallbackReceiver

/**
 * 快捷菜单工具类
 * Create by zcq at 5/20/22
 * 使用androidx中ShortcutManagerCompat库，兼容高低系统版本
 */
object ShortcutUtils {

    /**
     * 添加快捷菜单
     */
    @Throws(Exception::class)
    fun addShortcut(context: Context): String{
        val enter = getAppEnter(context, "com.zcq.learning")
        val uuid = "lk_shortcut"
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            if (ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
                //构建点击intent
                val shortcutInfoIntent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    setClassName("com.zcq.learning", enter)
                    addCategory(Intent.CATEGORY_LAUNCHER)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    putExtra("duplicate", false)//不允许重复创建
                }
                //目标intent
                val intent = Intent(context, TestActivity::class.java)
                intent.action = Intent.ACTION_VIEW
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                val intents = arrayOfNulls<Intent>(2)
                intents[0] = shortcutInfoIntent
                intents[1] = intent

                //构建快捷方式信息
                val pinShortcutInfo = ShortcutInfoCompat.Builder(context, uuid)
                    .setShortLabel("搜索")
//                    .setActivity(ComponentName(context, TestActivity::class.java))
                    .setIcon(IconCompat.createWithResource(context, R.drawable.ic_shortcut_search))
                    .setIntents(intents)
                    .build()

                //回调intent
                val successCallback = PendingIntent.getBroadcast(
                    context, 1000, Intent(context, IconAddCallbackReceiver::class.java),
                    PendingIntent.FLAG_UPDATE_CURRENT
                )

                //添加
                ShortcutManagerCompat.requestPinShortcut(
                    context,
                    pinShortcutInfo,
                    successCallback.intentSender
                )
            }
        } else {
//            //构建点击intent
//            val shortcutInfoIntent = Intent().apply {
//                action = Intent.ACTION_VIEW
//                setClassName("com.zcq.learning", enter)
//                addCategory(Intent.CATEGORY_LAUNCHER)
//                putExtra("duplicate", false)//不允许重复创建
//                //设置点击快捷方式，进入指定的Activity
//                //注意：因为是从Lanucher中启动，所以这里用到了ComponentName
//                //其中new ComponentName这里的第二个参数，是Activity的全路径名，也就是包名类名要写全。
//                component = ComponentName("", enter)
//                flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            }
//            //给Intent添加 对应的flag
//            val resultIntent = Intent().apply {
//                // Intent.ShortcutIconResource.fromContext 这个就是设置快捷方式的图标
//                putExtra(Intent.EXTRA_SHORTCUT_ICON, AppComUtil.drawableToBitmap(build.icon))
//                //启动的Intent
//                putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutInfoIntent)
//                //这里可以设置快捷方式的名称
//                putExtra(Intent.EXTRA_SHORTCUT_NAME, "com.zcq.learning")
//                //设置Action
//                action = "com.android.launcher.action.INSTALL_SHORTCUT"
//            }
//
//            //发送广播、通知系统创建桌面快捷方式
//            context.sendBroadcast(resultIntent)
        }
        return ""
    }

    /**
     * 移除快捷菜单
     */
    fun removeShortcut(){

    }

    /**
     * 更新快捷菜单
     */
    fun updateShortcut(){

    }

    /**
     * 通过包名获取app的入口activity
     */
    @SuppressLint("WrongConstant", "QueryPermissionsNeeded")
    fun getAppEnter(context: Context, packageName: String): String {
        var mainAct = ""
        try {
            val intent = Intent().apply {
                action = Intent.ACTION_MAIN
                addCategory(Intent.CATEGORY_LAUNCHER)
            }
            val list =
                context.packageManager.queryIntentActivities(intent, PackageManager.GET_ACTIVITIES)
            list.forEach {
                if (TextUtils.equals(it.activityInfo.packageName, packageName)) {
                    Log.e("-appEnter-","-------> activityName: " + it.activityInfo.name)
                    mainAct = it.activityInfo.name
                }
            }
        } catch (e: java.lang.Exception){

        } finally {
            return mainAct
        }
    }
}