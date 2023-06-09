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
import com.bayutb.gombti.ui.main.SessionManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var userId: String?= null
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this@MainActivity)
        userId = sessionManager.checkAuth()
        sessionCheck(userId)

        val loginSession = LoginSession(
            userId ?: "",
            sessionManager.getName() ?: "",
            sessionManager.getEmail() ?: "",
            sessionManager.getMbti() ?: ""
        )

        val homeBundle = Bundle()
        val personalityBundle = Bundle()
        val accountBundle = Bundle()

        homeBundle.putParcelableArrayList("session", arrayListOf(loginSession))
        personalityBundle.putString("mbti", loginSession.mbti)
        accountBundle.putParcelableArrayList("session", arrayListOf(loginSession))

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

                    else -> {
                        true
                    }
                }
            }
        }
    }

    fun logout() {
        sessionManager.clearAuth()
        Intent(this@MainActivity, LoginActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }

    private fun sessionCheck(userId: String?) {
        if (userId == null) {
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