package com.bayutb.gombti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bayutb.gombti.databinding.ActivityMainBinding
import com.bayutb.gombti.ui.main.AccountFragment
import com.bayutb.gombti.ui.main.HomeFragment
import com.bayutb.gombti.ui.main.PersonalityFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TEST SESSION
        val loginSession = arrayListOf(
            "1", "Bayu Tantra Bramandhita", "ISTJ", "Ahli Logistik", "Individu yang praktis dan berpikiran fakta yang kendalanya tidak diragukan lagi. Mereka cenderung terorganisir, bertanggung jawab, dan dapat diandalkan. ISTJ memiliki ketelitian tinggi dalam menjalankan tugas-tugas yang terstruktur.", "token123"
        )

        val homeBundle = Bundle()
        homeBundle.putString("token", loginSession[5])
        homeBundle.putString("name", loginSession[1])
        homeBundle.putString("personalityDescription", loginSession[4])
        homeBundle.putString("mbti", loginSession[2])
        homeBundle.putString("personality", loginSession[3])

        val personalityBundle = Bundle()
        personalityBundle.putString("mbti", loginSession[2])

        val accountBundle = Bundle()
        accountBundle.putStringArrayList("session", loginSession)

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

    private fun loadFragment(fragment: Fragment, bundle: Bundle) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragment.arguments = bundle
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }
}