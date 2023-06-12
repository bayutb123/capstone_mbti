package com.bayutb.gombti.ui.mbti

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bayutb.gombti.R
import com.bayutb.gombti.api.ApiConfig
import com.bayutb.gombti.api.request.MbtiRequest
import com.bayutb.gombti.api.responses.MbtiTestResponse
import com.bayutb.gombti.data.DataSource
import com.bayutb.gombti.databinding.ActivityMbtiBinding
import com.bayutb.gombti.ui.login.LoginActivity
import com.bayutb.gombti.ui.register.RegisterSessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MbtiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMbtiBinding
    private lateinit var questionsList: List<String>
    private lateinit var sessionManager: RegisterSessionManager
    private var index = 0
    private var points= mutableListOf<String>()
    private var mbtiType = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMbtiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = RegisterSessionManager(this@MbtiActivity)

        questionsList = DataSource.getQuestions()

        val totalQuestions = questionsList.size
        val userId = intent.getStringExtra("userId")

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
                    rbYes.id -> "Y"
                    rbNo.id -> "N"
                    else -> "N"
                }
                points.add(point)
                rgAnswer.clearCheck()
                btnNext.isEnabled = false
                index += 1
                tvCurrentQuestion.text = (index + 1).toString()

                when (index) {
                    totalQuestions -> {
                        tvQuestion.text = ""
                        btnNext.visibility = View.INVISIBLE
                        llCurrentTotal.visibility = View.INVISIBLE
                        ApiConfig.getMbtiInstance().mbtiTest(MbtiRequest(points.toTypedArray())).enqueue( object : Callback<MbtiTestResponse> {
                            override fun onResponse(
                                call: Call<MbtiTestResponse>,
                                response: Response<MbtiTestResponse>
                            ) {
                                if (response.isSuccessful) {
                                    if (response.body() != null) {
                                        mbtiType = response.body()!!.predictedMbti
                                        if (userId != null) {
                                            showAlert2(
                                                this@MbtiActivity,
                                                "Result MBTI : $mbtiType",
                                                userId,
                                                mbtiType,
                                                sessionManager
                                            )

                                        }
                                    }
                                } else {
                                    Toast.makeText(this@MbtiActivity, "Failed to retrieve mbti type from our server", Toast.LENGTH_SHORT).show()
                                }
                                Log.d("Failure Data : ", points.toTypedArray().toString())
                            }

                            override fun onFailure(call: Call<MbtiTestResponse>, t: Throwable) {
                                Toast.makeText(this@MbtiActivity, "Failed to retrieve mbti type from our server", Toast.LENGTH_SHORT).show()
                            }


                        })
                    }
                    totalQuestions - 1 -> {
                        btnNext.text = getString(R.string.btn_finish)
                    }
                    else -> {
                        tvQuestion.text = questionsList[index]
                    }

                }

                Log.d("Check Data : ", "$points")
            }
        }
    }
}

private fun showAlert(context: Context, message :String, sessionManager: RegisterSessionManager) {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.setMessage(message)
    alertDialog.setPositiveButton(context.getString(R.string.dialog_mbti_positive)) { dialogInterface: DialogInterface, _: Int ->
        sessionManager.clearSession()
        Intent(context, LoginActivity::class.java).also {
            context.startActivity(it)
        }
        (context as MbtiActivity).finish()
        dialogInterface.dismiss()
    }

    val dialog = alertDialog.create()
    dialog.show()
}

private fun showAlert2(context: Context, message :String, userId: String, mbtiType : String, sessionManager: RegisterSessionManager) {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.setMessage(message)
    alertDialog.setPositiveButton(context.getString(R.string.dialog_mbti_positive)) { dialogInterface: DialogInterface, _: Int ->
        showAlert(context,
            "Tes MBTI selesai \nPost to /mbtiResult: \nuserId = $userId \nmbtiType = $mbtiType", sessionManager)
        dialogInterface.dismiss()
        Log.d("Session Cleared: ", userId)
    }

    val dialog = alertDialog.create()
    dialog.show()
}