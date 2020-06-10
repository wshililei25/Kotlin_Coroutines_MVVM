package com.xilei.xiecheng.bean


/**
 * Created by XiLei on 2020/5/18
 */
class BaseResp<out T>(val status: Int, val msg: String, val timestamp: String, val obj: T? = null)