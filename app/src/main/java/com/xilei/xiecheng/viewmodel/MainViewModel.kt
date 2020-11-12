package com.xilei.xiecheng.viewmodel

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.xilei.xiecheng.bean.YiChuLiBean
import com.xilei.xiecheng.net.RetrofitClient
import com.xilei.xiecheng.repository.MainRepository
import com.yizhipin.base.ext.toastShort
import dagger.hilt.android.qualifiers.ActivityContext

/**
 * Created by XiLei on 2020/6/9
 */

class MainViewModel @ViewModelInject constructor(
    private var repository: MainRepository,
    @ActivityContext val context: Context,
    //SavedStateHandle 用于进程被终止时，存储和恢复数据
    @Assisted val savedState: SavedStateHandle
) : BaseViewModel() {

    private val datas: MutableLiveData<YiChuLiBean> by lazy {
        MutableLiveData<YiChuLiBean>().also { getData() }
    }


    /**
     * 老的写法
     */
    fun getActicle(): LiveData<YiChuLiBean> {
        return datas
    }

    /**
     * 新的写法
     *
     * 在 LifeCycle 2.2.0 之后，可以用更精简的方法来完成，使用 LiveData 协程构造方法 (coroutine builder)。
     * liveData 协程构造方法提供了一个协程代码块，产生的是一个不可变的 LiveData，emit() 方法则用来更新 LiveData 的数据。
     *
     * 具体可以查看之前写的这篇文章 [https://juejin.im/post/5ee998e8e51d4573d65df02b#heading-10] 有详细介绍
     */
    /*fun getActicle() = liveData {
        emit(datas.value!!)
    }*/

    private fun getData() = lunchUi {
        Log.d("XiLei", "loadDatas1 run in  ${Thread.currentThread().name}")
        val result = repository.getData()
        Log.d("XiLei", "loadDatas3 run in  ${Thread.currentThread().name}")
        if (result.code == RetrofitClient.SUCCESS_CODE) {
            datas.value = result.data
        } else context.toastShort(result.message)
    }


}