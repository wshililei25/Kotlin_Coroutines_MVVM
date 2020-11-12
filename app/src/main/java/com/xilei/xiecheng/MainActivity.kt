package com.xilei.xiecheng

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.xilei.xiecheng.bean.UserModel
import com.xilei.xiecheng.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mUserModel: UserModel
    private val mViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mUserModel.name = "Hilt"
        Timber.i("name=${mUserModel.name}")

        /**
         * 视图会通过数observe订阅的方式来观察这些 LiveData
         */
        mViewModel.getActicle().observe(this, Observer {
            it?.run {
                Timber.d("data=${records[0].user_name}")
            }
        })


    }
}