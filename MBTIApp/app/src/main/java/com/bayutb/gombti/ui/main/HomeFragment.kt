package com.bayutb.gombti.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bayutb.gombti.data.DataSource
import com.bayutb.gombti.databinding.FragmentHomeBinding
import com.bayutb.gombti.model.LoginSession

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var userData : ArrayList<LoginSession>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userData = arguments?.getParcelableArrayList("session")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val personalityType = DataSource.getPersonalityType(userData[0].mbti)
        val personalityDescription = DataSource.getPersonalityDesctiption(userData[0].mbti)
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.apply {
            tvFullName.text = userData[0].name
            tvMbtiType.text = userData[0].mbti
            tvPersonalityType.text = personalityType
            tvPersonalityDescription.text = personalityDescription
        }
        return binding.root
    }


}