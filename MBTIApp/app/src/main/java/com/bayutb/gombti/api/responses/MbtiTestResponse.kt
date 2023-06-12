package com.bayutb.gombti.api.responses

import com.google.gson.annotations.SerializedName

data class MbtiTestResponse(

	@field:SerializedName("predicted_mbti")
	val predictedMbti: String,

	@field:SerializedName("matched_mbti")
	val matchedMbti: String
)
