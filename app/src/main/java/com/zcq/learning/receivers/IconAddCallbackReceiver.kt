package com.zcq.learning.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * @Describe This is ...
 *
 * @Author cq.zhao
 * @CreationTime 2023/1/28 11:43
 */
class IconAddCallbackReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action == "action.test.shortcut") {
            Log.e("short_cut", "------> IconAddCallbackReceiver"+ intent.data.toString())
        }
    }
}