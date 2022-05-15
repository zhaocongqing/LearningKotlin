package com.zcq.learning.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Create by zcq at 5/15/22
 */
class ShoppingCartViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is shopping cart Fragment"
    }
    val text: LiveData<String> = _text
}