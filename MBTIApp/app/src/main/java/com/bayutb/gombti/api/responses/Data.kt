package com.bayutb.gombti.api.responses

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("userId")
	val userId: String,

	@field:SerializedName("email")
	val email: String
)