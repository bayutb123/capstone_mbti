package com.bayutb.gombti.ui.mbti

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bayutb.gombti.data.DataSource
import com.bayutb.gombti.databinding.ActivityMbtiBinding

class MbtiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMbtiBinding
    private lateinit var questionsList: List<String>
    private var index = 0
    private var points = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMbtiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionsList = DataSource.getQuestions()

        val totalQuestions = questionsList.size

        binding.apply {
            tvQuestion.text = questionsList[index]
            btnNext.isEnabled = false
            rgAnswer.setOnCheckedChangeListener { _, _ ->
                btnNext.isEnabled = true
            }
            tvTotalQuestion.text = totalQuestions.toString()
            tvCurrentQuestion.text = (index + 1).toString()
            btnNext.setOnClickListener {
                val point = when (rgAnswer.checkedRadioButtonId) {
                    rb1.id -> 1
                    rb2.id -> 2
                    rb3.id -> 3
                    rb4.id -> 4
                    rb5.id -> 5
                    else -> 0
                }
                points += point
                rgAnswer.clearCheck()
                btnNext.isEnabled = false
                index += 1
                tvCurrentQuestion.text = (index + 1).toString()
                if (index == totalQuestions) {
                    tvQuestion.text = "Tes MBTI selesai, poin kamu : $points, \nTotal Soal : $totalQuestions"
                    btnNext.visibility = View.INVISIBLE
                    llCurrentTotal.visibility = View.INVISIBLE
                } else {
                    tvQuestion.text = questionsList[index]
                }
            }
        }
    }
}