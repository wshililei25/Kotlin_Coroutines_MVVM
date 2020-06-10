package com.xilei.xiecheng.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xilei.xiecheng.bean.StudyClassifyBean
import com.xilei.xiecheng.net.RetrofitClient
import com.xilei.xiecheng.repository.MainRepository
import com.yizhipin.base.ext.toastShort

/**
 * Created by XiLei on 2020/6/9
 */
class MainViewModel(var context: Context) : BaseViewModel() {

    private val repository = MainRepository()
    private val datas: MutableLiveData<MutableList<StudyClassifyBean>> by lazy {
        MutableLiveData<MutableList<StudyClassifyBean>>().also { getData() }
    }

    fun getActicle(): LiveData<MutableList<StudyClassifyBean>> {
        return datas
    }

    private fun getData() = lunchUi {
        Log.d("XiLei", "loadDatas1 run in  ${Thread.currentThread().name}")
        val result = repository.getData()
        Log.d("XiLei", "loadDatas3 run in  ${Thread.currentThread().name}")
        if (result.status == RetrofitClient.SUCCESS_CODE) {
            datas.value = result.obj
        } else context.toastShort(result.msg)
    }

}