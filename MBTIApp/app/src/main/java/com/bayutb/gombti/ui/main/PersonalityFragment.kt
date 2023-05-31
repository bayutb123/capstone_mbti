package com.bayutb.gombti.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bayutb.gombti.adapters.RecyclerAdapter
import com.bayutb.gombti.data.DataSource
import com.bayutb.gombti.databinding.FragmentPersonalityBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PersonalityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonalityFragment : Fragment() {

    private lateinit var binding: FragmentPersonalityBinding
    private lateinit var listRecommendation: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        val mbti = bundle!!.getString("mbti")
        listRecommendation = mbti?.let { DataSource.getRecommendation(it) }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPersonalityBinding.inflate(inflater, container, false)
        binding.rvRecommendation.layoutManager = LinearLayoutManager(context)
        val adapter = RecyclerAdapter(listRecommendation)
        binding.rvRecommendation.adapter = adapter
        return binding.root
    }


}