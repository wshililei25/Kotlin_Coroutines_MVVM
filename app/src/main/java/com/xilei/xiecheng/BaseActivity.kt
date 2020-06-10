package com.xilei.xiecheng

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * Created by XiLei on 2020/6/9
 */
abstract class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onDestroy() {
        super.onDestroy()
        cancel() //取消协程
    }
}