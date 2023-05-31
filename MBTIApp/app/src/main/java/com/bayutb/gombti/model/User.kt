package com.bayutb.gombti.model

data class User(
    val accountId: Int,
    val fullName : String,
    val emailAddress :String,
    val password:String,
    val gender: String,
    val birthDate: String
)
