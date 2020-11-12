package com.xilei.xiecheng.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.xilei.xiecheng.api.RequestApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by XiLei on 2020/6/9
 *
 * object为了使RetrofitClient 只能有一个实例
 */

object RetrofitClient {

    val BASE_URL = "https://employeet0422.sancaijia.net/"
    val TIME_OUT = 10L
    val SUCCESS_CODE=200
    val requestApi by lazy {
        @Singleton
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(initClient())
            .build()
        return@lazy retrofit.create(RequestApi::class.java)
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(initInterceptor())
            .addInterceptor(initLogInterceptor())
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    private fun initInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .header("Content-Type", "application/json")
//                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("charset", "utf-8")
                .header("Accept", "application/json")
//                .header("token", "e1c917d0b36eb812c3a57a10d1a699ff")
                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJLZW4iLCJ0ZW5hbnRJZCI6MTAwMDAwMDAsInVzZXJUeXBlIjoiRU1QTE9ZRUVfUkVHSVNURVJFRCIsInVzZXJJZCI6MTI3NDAzMzU2MTkyNzY4LCJqdGkiOiJUT0tFTl8xMjc0MDMzNTYxOTI3NjhfYW5kcm9pZF83M2Y2ZDQwMzQ3ZThhNmQyZmE1ZjBjYzNkNjg1MzJkMGU2MTI0MmNjIiwicGxhdGZvcm0iOiJDTElFTlRfQU5EUk9JRCIsImhhc2giOiI3M2Y2ZDQwMzQ3ZThhNmQyZmE1ZjBjYzNkNjg1MzJkMGU2MTI0MmNjIn0.pK1c8b6pSVoQoKfcN96AzQQEgxaWEBoG0ycz3Dl8aHk")
                .header("deviceId", "869583031161115")
                .header("language", "zh")
                .get()
                .build()
            chain.proceed(request)
        }
    }

    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}