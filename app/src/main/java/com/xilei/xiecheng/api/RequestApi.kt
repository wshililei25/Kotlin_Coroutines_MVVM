package com.xilei.xiecheng.api

import com.xilei.xiecheng.bean.BaseResp
import com.xilei.xiecheng.bean.YiChuLiBean
import retrofit2.http.GET

/**
 * Created by XiLei on 2020/6/9
 */
interface RequestApi {

    /**
     * 已处理的待办
     */
    @GET("api/v1/housing/manager/approval/1?size=20&page=1&review_status=4&keyword=")
    suspend fun getYiChuliList(): BaseResp<YiChuLiBean>
}