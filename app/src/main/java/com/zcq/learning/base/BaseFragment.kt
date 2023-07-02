package com.zcq.learning.base

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Create by zcq at 5/30/22
 */
abstract class BaseFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected open fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    protected open fun showToast(resId: Int) {
        showToast(getString(resId))
    }

    protected open fun showLongToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    protected open fun showLongToast(resId: Int) {
        showLongToast(getString(resId))
    }
}