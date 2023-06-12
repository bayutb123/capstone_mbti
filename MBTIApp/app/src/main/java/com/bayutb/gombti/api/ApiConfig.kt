package com.bayutb.gombti.api

import com.bayutb.gombti.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiConfig {

    private const val baseUrl = BuildConfig.apiUrl
    private const val mbtiUrl = BuildConfig.mbtiUrl

    fun getInstance() : ApiService {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    fun getMbtiInstance() : ApiService {
        val retrofit = Retrofit.Builder().baseUrl(mbtiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }

}