package com.example.mvvc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private val _result = MutableLiveData<Int>(0)
    val result: LiveData<Int> get() = _result

    fun Plus() {
        if (_result.value != null)
            _result.value = result.value!! + 1
    }

}