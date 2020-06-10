package com.xilei.xiecheng.api

import com.xilei.xiecheng.bean.BaseResp
import com.xilei.xiecheng.bean.StudyClassifyBean
import retrofit2.http.GET

/**
 * Created by XiLei on 2020/6/9
 */
interface RequestApi {

    /**
     * 课程分类
     */
    @GET("fang/huoqu/edu/kind/getEduKindList")
    suspend fun getClassifyList(): BaseResp<MutableList<StudyClassifyBean>>
}