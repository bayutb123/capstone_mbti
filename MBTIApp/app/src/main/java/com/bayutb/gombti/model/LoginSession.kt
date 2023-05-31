package com.bayutb.gombti.model

data class LoginSession(
    val accountId: Int,
    val mbtiType : String,
    val personalityType : String,
    val token : String
)
