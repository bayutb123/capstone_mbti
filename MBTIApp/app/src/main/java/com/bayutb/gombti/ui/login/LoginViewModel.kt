package com.bayutb.gombti.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.bayutb.gombti.api.ApiConfig
import com.bayutb.gombti.api.responses.LoginResponse
import com.bayutb.gombti.model.LoginSession
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val loginResponse = arrayListOf<LoginSession>()

    fun loginUser(email: String, password: String) : List<LoginSession> {
        ApiConfig.getInstance().loginUser(email, password).enqueue(
            object: Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val loginResult = response.body()?.loginResult
                        if (loginResult != null) {
                            loginResponse.add(0, LoginSession(
                                loginResult.userId,
                                loginResult.name,
                                loginResult.email,
                                loginResult.mbti
                            ))
                        }
                        Log.d("Success : ", "$loginResult")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("Failure : ", "${t.message}")
                }
            }
        )

        return loginResponse
    }

}