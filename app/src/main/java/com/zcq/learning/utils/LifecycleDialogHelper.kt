package com.zcq.learning.utils

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Create by zcq at 5/30/22
 */
class LifecycleDialogHelper (private val fragmentManager: FragmentManager): LifecycleObserver {

    private var showable = false
    private val dialogFragments = mutableListOf<DialogFragment>()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        showable = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        showable = true
        notifyShow()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        showable = false
        dialogFragments.clear()
    }

    fun show(dialogFragment: DialogFragment) {
        if (dialogFragments.contains(dialogFragment)) return
        dialogFragments.add(dialogFragment)
        notifyShow()
    }

    private fun notifyShow() {
        if (!showable) return
        if (dialogFragments.size == 0) return
        val dialogFragment = dialogFragments.removeAt(0)
        if (!dialogFragment.isAdded && !dialogFragment.isResumed)
            dialogFragment.show(fragmentManager, null)
    }
}