package com.bayutb.gombti

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // [Test] Data From API Simulation
        val dataFromApi = LoginSession(
            1,
            "Bayu Tantra Bramandhita",
            "a150dsx2099@bangkit.academy",
            "INTP",
            "Ahli Logika",
            "Penemu inovatif dengan rasa haus yang tak terpadamkan akan pengetahuan. Mereka adalah pemikir yang kritis, analitis, dan cenderung melihat masalah dari berbagai sudut pandang. INTP sangat tertarik pada teori dan konsep-konsep abstrak.",
            "Token31231231"
        )

        loginSession.add(dataFromApi)

        sessionCheck(loginSession[0].token)

        val homeBundle = Bundle()
        homeBundle.putParcelableArrayList("session", loginSession)

        val personalityBundle = Bundle()
        personalityBundle.putString("mbti", loginSession[0].mbtiType)

        val accountBundle = Bundle()
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