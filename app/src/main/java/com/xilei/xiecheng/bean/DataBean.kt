package com.xilei.xiecheng.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class YiChuLiBean(
    val records: MutableList<YiChuLiItemBean>
) : Parcelable

@Parcelize
data class YiChuLiItemBean(
    val apply_time: String,
    val avatar_url: String,
    val comments: String,
    val final_review_time: String,
    val final_review_user_id: String,
    val final_review_user_name: String,
    val final_review_user_phone: String,
    val housing_id: String,
    val housing_name: String,
    val id: String,
    val leaders: String,
    val review_status: Int,
    val review_status_display: String,
    val use_way: Int,
    val use_way_display: String,
    val user_id: String,
    val user_name: String,
    val user_phone: String
) : Parcelable