package com.xilei.xiecheng.bean

import javax.inject.Inject

/**
 * created by XiLei on 2020/11/10
 * Describe:
 */
data class UserModel(var name: String) {
    @Inject
    constructor() : this("开始讲课了")
}