package com.bayutb.gombti.api

import com.bayutb.gombti.api.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("email") emailAddress: String,
        @Field("password") password: String
    ) : Call<LoginResponse>

}