package com.xilei.xiecheng.repository

import com.xilei.xiecheng.bean.BaseResp
import com.yizhipin.base.ext.exceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by XiLei on 2020/6/10
 */
open class BaseRepository {

    suspend fun <T : Any> request(call: suspend () -> BaseResp<T>): BaseResp<T> {
        /**
         * Kotlin 提供了三个调度器 Dispatchers.MAIN  Dispatchers.IO  Dispatchers.DEFAULT
         *
         * 调用 withContext(Dispatchers.IO) 来创建一个在 IO 线程池中运行的块。您放在该块内的任何代码都始终通过 IO 调度器执行。
         * 由于 withContext 本身就是一个 suspend 函数，它会使用协程来保证主线程安全
         */
        return withContext(Dispatchers.IO + exceptionHandler) { call.invoke() }
    }
}