package com.xilei.xiecheng.bean


/**
 * Created by XiLei on 2020/5/18
 */
class BaseResp<out T>(val code: Int, val message: String, val timestamp: String, val data: T? = null)