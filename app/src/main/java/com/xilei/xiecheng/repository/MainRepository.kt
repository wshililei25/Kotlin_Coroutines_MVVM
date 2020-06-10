package com.xilei.xiecheng.repository

import android.util.Log
import com.xilei.xiecheng.bean.BaseResp
import com.xilei.xiecheng.bean.StudyClassifyBean
import com.xilei.xiecheng.net.RetrofitClient

/**
 * Created by XiLei on 2020/6/9
 */
class MainRepository : BaseRepository() {
    suspend fun getData(): BaseResp<MutableList<StudyClassifyBean>> = request {
        Log.d("XiLei", "loadDatas2 run in  ${Thread.currentThread().name}")
        RetrofitClient.requestApi.getClassifyList()
    }
}