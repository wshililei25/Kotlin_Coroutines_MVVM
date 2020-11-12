package com.xilei.xiecheng.repository

import android.util.Log
import com.xilei.xiecheng.bean.BaseResp
import com.xilei.xiecheng.bean.YiChuLiBean
import com.xilei.xiecheng.net.RetrofitClient
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * Created by XiLei on 2020/6/9
 */
@ActivityScoped
class MainRepository @Inject constructor() : BaseRepository() {
    suspend fun getData(): BaseResp<YiChuLiBean> = request {
        Log.d("XiLei", "loadDatas2 run in  ${Thread.currentThread().name}")
        RetrofitClient.requestApi.getYiChuliList()
    }
}