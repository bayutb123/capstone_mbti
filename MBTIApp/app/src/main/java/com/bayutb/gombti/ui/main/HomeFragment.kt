package com.bayutb.gombti.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bayutb.gombti.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var fullName: String
    private lateinit var mbtiType: String
    private lateinit var personalityType : String
    private lateinit var personalityDescription : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        mbtiType = bundle!!.getString("mbti") ?: "Error"
        personalityType = bundle.getString("personality") ?: "Error"
        personalityDescription = bundle.getString("personalityDescription") ?: "Error"
        fullName = bundle.getString("name") ?: "Error"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.apply {
            tvFullName.text = fullName
            tvMbtiType.text = mbtiType
            tvPersonalityType.text = personalityType
            tvPersonalityDescription.text = personalityDescription
        }
        return binding.root
    }


}