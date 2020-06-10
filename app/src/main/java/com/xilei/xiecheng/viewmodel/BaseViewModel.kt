package com.xilei.xiecheng.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by XiLei on 2020/6/10
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {

    //运行在UI线程的协程
    fun lunchUi(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        block()
    }
}