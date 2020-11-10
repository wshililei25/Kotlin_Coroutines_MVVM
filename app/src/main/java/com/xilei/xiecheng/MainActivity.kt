package com.xilei.xiecheng

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.xilei.xiecheng.bean.UserModel
import com.xilei.xiecheng.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mUserModel: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * 视图会通过数observe订阅的方式来观察这些 LiveData
         */
        MainViewModel(this).getActicle().observe(this, Observer {
            it?.run {
//                Log.d("XiLei", "data=${get(0)?.records[0].user_name}")
                Log.d("XiLei", "data=${records[0].user_name}")
            }
        })

        mUserModel.name = "Hilt"
        Log.d("XiLei", "name=${mUserModel.name}")
    }
}