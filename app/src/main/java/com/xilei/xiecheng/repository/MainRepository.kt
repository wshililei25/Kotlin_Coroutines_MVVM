package com.xilei.xiecheng.repository

import android.util.Log
import com.xilei.xiecheng.bean.BaseResp
import com.xilei.xiecheng.bean.YiChuLiBean
import com.xilei.xiecheng.net.RetrofitClient

/**
 * Created by XiLei on 2020/6/9
 */
class MainRepository : BaseRepository() {
    suspend fun getData(): BaseResp<YiChuLiBean> = request {
        Log.d("XiLei", "loadDatas2 run in  ${Thread.currentThread().name}")
        RetrofitClient.requestApi.getYiChuliList()
    }
}