package com.xilei.xiecheng.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xilei.xiecheng.bean.YiChuLiBean
import com.xilei.xiecheng.net.RetrofitClient
import com.xilei.xiecheng.repository.MainRepository
import com.yizhipin.base.ext.toastShort

/**
 * Created by XiLei on 2020/6/9
 */
class MainViewModel(var context: Context) : BaseViewModel() {

    private val repository = MainRepository()
    private val datas: MutableLiveData<YiChuLiBean> by lazy {
        MutableLiveData<YiChuLiBean>().also { getData() }
    }

    fun getActicle(): LiveData<YiChuLiBean> {
        return datas
    }

    private fun getData() = lunchUi {
        Log.d("XiLei", "loadDatas1 run in  ${Thread.currentThread().name}")
        val result = repository.getData()
        Log.d("XiLei", "loadDatas3 run in  ${Thread.currentThread().name}")
        if (result.code == RetrofitClient.SUCCESS_CODE) {
            datas.value = result.data
        } else context.toastShort(result.message)
    }


}