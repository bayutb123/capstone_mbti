package com.bayutb.gombti.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginSession(
    val userId: String,
    val name: String,
    val email: String,
    val mbti: String
) : Parcelable