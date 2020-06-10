package com.yizhipin.base.ext

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

/**
 * Created by XiLei on 2020/5/12
 */

/**
 * Retrofit请求 异常拦截
 */
val exceptionHandler: CoroutineContext = CoroutineExceptionHandler { _, throwable ->
    Log.e("XiLei", "throwable异常 =$throwable")
    throwable.printStackTrace()
}

fun Context.startActivityExt(clas: Class<*>) {
    startActivity(Intent(this, clas))
}

/**
 * 点击事件扩展方法
 */
fun View.onClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

/**
 * 点击事件扩展方法
 */
fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}

/**
 * 控件隐藏显示
 */
fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

/**
 * 扩展Button可用性
 */
/*fun Button.enable(editText: EditText, method: () -> Boolean) {
    val btn = this
    editText.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}*/

/**
 * RadioGroup下所有的RadioButton不可点击
 */
fun disableRadioGroup(testRadioGroup: RadioGroup) {
    for (i in 0 until testRadioGroup.childCount) {
        testRadioGroup.getChildAt(i).isEnabled = false
    }
}

/**
 * ImageView加载网络图片
 */
/*
fun ImageView.loadUrl(url: String?) {
    if (!TextUtils.isEmpty(url)) {
        GlideUtil.setImgUrl(context, url, this)
    }
}

*/
/**
 * ImageView加载网络图片 带加载错误图片
 *//*

fun ImageView.loadUrl(url: String?, erroImg: Int) {
    if (!TextUtils.isEmpty(url)) {
        GlideUtil.setImgUrl(context, url, erroImg, this)
    }
}

*/
/**
 * ImageView加载圆角
 *//*

fun ImageView.loadUrlRound(url: String) {
    if (!TextUtils.isEmpty(url)) {
        GlideUtil.loadRoundImage(context, url, this, 10)
    }
}*/

fun Context.toastShort(s: String) {
    Toast.makeText(applicationContext, s, Toast.LENGTH_SHORT).show()
}

fun Context.toastLong(s: String) {
    Toast.makeText(applicationContext, s, Toast.LENGTH_LONG).show()
}
