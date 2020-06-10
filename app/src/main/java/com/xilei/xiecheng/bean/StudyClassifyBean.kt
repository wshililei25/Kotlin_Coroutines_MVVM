package com.xilei.xiecheng.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by XiLei on 2020/5/18
 */
@Parcelize
class StudyClassifyBean(var icon: String,
                        var id: String,
                        var level: String,
                        var name: String,
                        var parentId: String,
                        var sort: String,
                        var kindDTOS :MutableList<StudyClassifyTwoBean>,
                        var isSelected: Boolean) : Parcelable