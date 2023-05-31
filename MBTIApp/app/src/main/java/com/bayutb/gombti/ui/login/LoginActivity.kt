package com.bayutb.gombti.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bayutb.gombti.MainActivity
import com.bayutb.gombti.ui.register.RegisterActivity
import com.bayutb.gombti.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnLogin.setOnClickListener {
                Intent(this@LoginActivity, MainActivity::class.java).also {
                    startActivity(it)
                }
                finish()
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