package com.bayutb.gombti.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginSession(
    val accountId: Int,
    val fullName: String,
    val emailAddress: String,
    val mbtiType : String,
    val personalityType : String,
    val personalityDescription : String,
    val token : String
) : Parcelable