package com.bayutb.gombti.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bayutb.gombti.MainActivity
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
                    sessionManager = SessionManager(this@LoginActivity)
                    sessionManager.saveAuth(loginSession[0].userId, loginSession[0].name, loginSession[0].email, loginSession[0].mbti)
                    Toast.makeText(this@LoginActivity, "Selamat datang, ${loginSession[0].name}", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("userId", loginSession[0].userId)
                    intent.putExtra("name", loginSession[0].name)
                    intent.putExtra("email", loginSession[0].email)
                    intent.putExtra("mbti", loginSession[0].mbti)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, "Tekan login sekali lagi", Toast.LENGTH_LONG).show()
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