package com.bayutb.gombti.ui.mbti

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bayutb.gombti.R
import com.bayutb.gombti.data.DataSource
import com.bayutb.gombti.databinding.ActivityMbtiBinding
import com.bayutb.gombti.ui.login.LoginActivity

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
        val userId = intent.getStringExtra("userId")

        if (userId != null) {
            Log.d("UserID : ", userId)
        }

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
                    tvQuestion.text = ""
                    btnNext.visibility = View.INVISIBLE
                    llCurrentTotal.visibility = View.INVISIBLE
                    showAlert2(this@MbtiActivity,
                        "Tes MBTI selesai \nPost to /mbtiTest: \npoint = $points", userId!!)

                } else if (index == totalQuestions -1) {
                    btnNext.text = getString(R.string.btn_finish)
                } else {
                    tvQuestion.text = questionsList[index]
                }
            }
        }
    }
}

private fun showAlert(context: Context, message :String) {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.setMessage(message)
    alertDialog.setPositiveButton(context.getString(R.string.dialog_mbti_positive)) { dialogInterface: DialogInterface, _: Int ->
        Intent(context, LoginActivity::class.java).also {
            context.startActivity(it)
        }
        (context as MbtiActivity).finish()
        dialogInterface.dismiss()
    }

    val dialog = alertDialog.create()
    dialog.show()
}

private fun showAlert2(context: Context, message :String, userId: String) {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.setMessage(message)
    alertDialog.setPositiveButton(context.getString(R.string.dialog_mbti_positive)) { dialogInterface: DialogInterface, _: Int ->
        showAlert(context,
            "Tes MBTI selesai \nPost to /mbtiResult: \nuserId = $userId \nmbtiType = 'response dari /mbtiTest'")
        dialogInterface.dismiss()
    }

    val dialog = alertDialog.create()
    dialog.show()
}