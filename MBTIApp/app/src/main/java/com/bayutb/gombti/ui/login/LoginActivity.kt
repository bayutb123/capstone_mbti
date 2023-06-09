package com.bayutb.gombti.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bayutb.gombti.MainActivity
import com.bayutb.gombti.R
import com.bayutb.gombti.databinding.ActivityLoginBinding
import com.bayutb.gombti.model.LoginSession
import com.bayutb.gombti.ui.main.SessionManager
import com.bayutb.gombti.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var loginSession: List<LoginSession>
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.apply {

            btnLogin.setOnClickListener {

                val emailAddress = etEmailAddress.text.toString()
                val password = etPassword.text.toString()

                loginSession = viewModel.loginUser(emailAddress, password)

                if (loginSession.isNotEmpty()) {
                    if (loginSession[0].userId == "invalid") {
                        Toast.makeText(this@LoginActivity, getString(R.string.toast_login_wrong_cridential), Toast.LENGTH_LONG).show()
                        viewModel.clear()
                    } else {
                        sessionManager = SessionManager(this@LoginActivity)
                        sessionManager.saveAuth(loginSession[0].userId, loginSession[0].name, loginSession[0].email, loginSession[0].mbti)
                        Toast.makeText(this@LoginActivity, getString(R.string.toast_welcome, loginSession[0].name), Toast.LENGTH_LONG).show()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, getString(R.string.toast_login_btn_press_again), Toast.LENGTH_SHORT).show()
                }

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