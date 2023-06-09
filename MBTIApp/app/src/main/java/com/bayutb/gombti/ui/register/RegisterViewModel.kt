package com.bayutb.gombti.ui.register

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.bayutb.gombti.api.ApiConfig
import com.bayutb.gombti.api.responses.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    var userData = mutableListOf<String>()

    fun registerUser(name: String, email: String, password: String, gender: String, birthDate: String) {
        ApiConfig.getInstance().registerUser(name, email, password, gender, birthDate).enqueue(
            object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        if (response.body()?.message == "Account created") {
                            userData.add(0,response.body()!!.data.userId)
                        }
                    }
                    Log.d("Success : " , userData[0])
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("Failure : ", t.message.toString())
                }

            }
        )
    }

    fun getUserId(): List<String> {
        return userData
    }
}