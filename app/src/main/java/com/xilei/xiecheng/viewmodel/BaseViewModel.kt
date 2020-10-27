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

    /**
     * 运行在UI线程的协程
     * CoroutineScope 可以对协程进行追踪，即使协程被挂起也是如此；
     * CoroutineScope 并不运行协程，它只是确保您不会失去对协程的追踪；
     * CoroutineScope 会跟踪所有协程，并且可以取消由它所启动的所有协程；
     * 为了确保所有的协程都会被追踪，Kotlin 不允许在没有使用 CoroutineScope 的情况下启动新的协程。CoroutineScope
     * 可被看作是一个具有超能力的 ExecutorService 的轻量级版本。它能启动新的协程，同时这个协程还具备我们在第一部分
     * 所说的 suspend 和 resume 的优势；
     *
     * 调用launch创建并启动协程 ：构建器适合执行 "一劳永逸" 的工作，意思就是说它可以启动新协程而不将结果返回给调用方；
     * 您可以将 launch 看作是将代码从常规函数送往协程世界的桥梁。在 launch 函数体内，您可以调用 suspend 函数并能够像我们上一篇介绍的那样保证主线程安全
     */

    /**
     * 通过使用 viewModelScope，可以确保所有的任务，包含死循环在内，都可以在不需要的时候被取消掉
     */
    fun lunchUi(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        block()
    }
}