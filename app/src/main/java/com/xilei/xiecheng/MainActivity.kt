package com.xilei.xiecheng

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.xilei.xiecheng.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
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
    }
}