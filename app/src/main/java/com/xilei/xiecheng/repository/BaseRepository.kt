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
        return withContext(Dispatchers.IO + exceptionHandler) { call.invoke() }
    }
}