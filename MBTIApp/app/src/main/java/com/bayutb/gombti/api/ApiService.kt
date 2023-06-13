package com.bayutb.gombti.api

import com.bayutb.gombti.api.request.MbtiRequest
import com.bayutb.gombti.api.responses.LoginResponse
import com.bayutb.gombti.api.responses.MbtiTestResponse
import com.bayutb.gombti.api.responses.RegisterResponse
import com.bayutb.gombti.api.responses.ResultMbtiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("email") emailAddress: String,
        @Field("password") password: String
    ) : Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun registerUser(
        @Field("name") name :String,
        @Field("email") emailAddress: String,
        @Field("password") password: String,
        @Field("gender") gender: String,
        @Field("birthdate") birthDate: String,
    ) : Call<RegisterResponse>

    @FormUrlEncoded
    @POST("result")
    fun registerMbti(
        @Field("userId") userId: String,
        @Field("mbtiType") mbtiType: String
    ) : Call<ResultMbtiResponse>

    @POST("predict")
    @Headers("Content-Type: application/json;charset=UTF-8")
    fun mbtiTest(@Body body: MbtiRequest?): Call<MbtiTestResponse>

}