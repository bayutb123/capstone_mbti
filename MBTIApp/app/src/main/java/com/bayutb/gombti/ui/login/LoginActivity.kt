package com.bayutb.gombti.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bayutb.gombti.MainActivity
import com.bayutb.gombti.R
import com.bayutb.gombti.api.ApiConfig
import com.bayutb.gombti.api.responses.LoginResponse
import com.bayutb.gombti.databinding.ActivityLoginBinding
import com.bayutb.gombti.ui.main.SessionManager
import com.bayutb.gombti.ui.register.RegisterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this@LoginActivity)

        binding.apply {

            btnLogin.setOnClickListener {
                val emailAddress = etEmailAddress.text.toString()
                val password = etPassword.text.toString()

                ApiConfig.getInstance().loginUser(emailAddress, password).enqueue(
                    object: Callback<LoginResponse> {
                        override fun onResponse(
                            call: Call<LoginResponse>,
                            response: Response<LoginResponse>
                        ) {
                            if (response.isSuccessful) {
                                val loginResult = response.body()?.loginResult
                                if (loginResult != null) {
                                    sessionManager.saveAuth(loginResult.userId.toString(), loginResult.name, loginResult.email, loginResult.mbti)
                                    Toast.makeText(this@LoginActivity, getString(R.string.toast_welcome, loginResult.name), Toast.LENGTH_SHORT).show()
                                    Intent(this@LoginActivity, MainActivity::class.java).also { startActivity(it) }
                                }
                            } else if (response.body()!!.error) {
                                Toast.makeText(this@LoginActivity, getString(R.string.toast_login_wrong_cridential), Toast.LENGTH_SHORT).show()
                                Log.d("Success : ", "${response.body()}")
                            }
                        }

                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            Log.d("Failure : ", "${t.message}")
                        }
                    }
                )
            }

            goRegister.setOnClickListener {
                Intent(this@LoginActivity, RegisterActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

        }
    }
}