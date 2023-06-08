package com.bayutb.gombti.ui.main

import android.content.Context
import android.content.SharedPreferences
import com.bayutb.gombti.R

class SessionManager(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun saveAuth(userId: String, name: String, email: String, mbti: String) {
        val editor = prefs.edit()
        editor.putString(USER_ID, userId)
        editor.putString(USER_NAME, name)
        editor.putString(USER_EMAIL, email)
        editor.putString(USER_MBTI, mbti)
        editor.apply()
    }

    fun checkAuth() : String? {
        return prefs.getString(USER_ID, null)
    }

    fun getName(): String? {
        return prefs.getString(USER_NAME, null)
    }

    fun getEmail(): String? {
        return prefs.getString(USER_EMAIL, null)
    }

    fun getMbti(): String? {
        return prefs.getString(USER_MBTI, null)
    }

    fun clearAuth() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        const val USER_ID = "user_id"
        const val USER_NAME = "user_name"
        const val USER_EMAIL = "user_email"
        const val USER_MBTI = "user_mbti"
    }
}