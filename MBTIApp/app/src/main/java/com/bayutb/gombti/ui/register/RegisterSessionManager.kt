package com.bayutb.gombti.ui.register

import android.content.Context
import android.content.SharedPreferences
import com.bayutb.gombti.R

class RegisterSessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun saveSession(userId: String, userName: String) {
        val editor = prefs.edit()
        editor.putString(USER_ID_REGISTER, userId)
        editor.putString(USER_NAME_REGISTER, userName)
        editor.apply()
    }

    fun loadSession(): String? {
        return prefs.getString(USER_ID_REGISTER, null)
    }

    fun getUserName() : String? {
        return prefs.getString(USER_NAME_REGISTER, null)
    }

    fun clearSession() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private const val USER_ID_REGISTER = "user_id_register"
        private const val USER_NAME_REGISTER = "user_name_register"
    }
}