package com.bayutb.gombti.api.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("loginResult")
	val loginResult: LoginResult,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class LoginResult(

	@field:SerializedName("personality")
	val personality: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("mbti")
	val mbti: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("userId")
	val userId: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("token")
	val token: String
)
