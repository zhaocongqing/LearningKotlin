package com.zcq.learning.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoundViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is found Fragment"
    }
    val text: LiveData<String> = _text
}