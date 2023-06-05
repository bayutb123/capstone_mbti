package com.bayutb.gombti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bayutb.gombti.databinding.ActivityMainBinding
import com.bayutb.gombti.model.LoginSession
import com.bayutb.gombti.ui.login.LoginActivity
import com.bayutb.gombti.ui.main.AccountFragment
import com.bayutb.gombti.ui.main.HomeFragment
import com.bayutb.gombti.ui.main.PersonalityFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var loginSession: ArrayList<LoginSession> = ArrayList()
    private var token: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // [Test] Data From API Response Simulation
        val dataFromApi = LoginSession(
            1,
            "Bayu Tantra Bramandhita",
            "a150dsx2099@bangkit.academy",
            "INFP",
            "Token31231231 (Jika ada)"
        )

        loginSession.add(dataFromApi)

        // loginSession.clear() // Simulate Not have token

        // Get Token if Session is Exists or token will be null
        if (loginSession.size > 0) {
            token = loginSession[0].token
        }

        sessionCheck(token)

        val homeBundle = Bundle()
        val personalityBundle = Bundle()
        val accountBundle = Bundle()

        homeBundle.putParcelableArrayList("session", loginSession)
        personalityBundle.putString("mbti", loginSession[0].mbtiType)
        accountBundle.putParcelableArrayList("session", loginSession)

        loadFragment(HomeFragment(), homeBundle)

        binding.apply {
            bottomNav.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        loadFragment(HomeFragment(), homeBundle)
                        true
                    }
                    R.id.personality -> {
                        loadFragment(PersonalityFragment(), personalityBundle)
                        true
                    }
                    R.id.account -> {
                        loadFragment(AccountFragment(), accountBundle)
                        true
                    }
                    else -> { true }
                }
            }
        }
    }

    fun logout() {
        loginSession.clear()
        Intent(this@MainActivity, LoginActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }

    private fun sessionCheck(token: String?) {
        if (token == null) {
            Intent(this@MainActivity, LoginActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }
    }

    private fun loadFragment(fragment: Fragment, bundle: Bundle) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragment.arguments = bundle
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }
}