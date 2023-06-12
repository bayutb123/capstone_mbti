package com.bayutb.gombti.ui.register

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bayutb.gombti.R
import com.bayutb.gombti.api.ApiConfig
import com.bayutb.gombti.api.responses.RegisterResponse
import com.bayutb.gombti.databinding.ActivityRegisterBinding
import com.bayutb.gombti.ui.login.LoginActivity
import com.bayutb.gombti.ui.mbti.MbtiActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sessionManager: RegisterSessionManager
    private var userId = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = RegisterSessionManager(this@RegisterActivity)

        if (sessionManager.loadSession() != null) {
            registerAlert(
                this@RegisterActivity,
                getString(R.string.dialog_register_session_exists,
                sessionManager.getUserName()),
                sessionManager.loadSession()!!
            )
            Log.d("Session Exists : ", sessionManager.loadSession()!!)
        }

        binding.apply {
            etBirthDate.showSoftInputOnFocus = false
            etBirthDate.setOnClickListener {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val datePickerDialog = DatePickerDialog(
                    this@RegisterActivity,
                    { _, _year, _monthOfYear, _dayOfMonth ->
                        // on below line we are setting
                        // date to our edit text.
                        val dat =
                            (_year.toString() + "-" + (_monthOfYear + 1) + "-" + _dayOfMonth.toString())
                        etBirthDate.setText(dat)
                    },
                    year,
                    month,
                    day
                )
                datePickerDialog.show()
            }

            goLogin.setOnClickListener {
                Intent(this@RegisterActivity, LoginActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            }

            btnRegister.setOnClickListener {
                val name = etFullName.text.toString()
                val email = etEmailAddress.text.toString()
                val password = etPassword.text.toString()
                val rePassword = etRePassword.text.toString()
                val gender = when (rgGender.checkedRadioButtonId) {
                    rbMale.id -> "Male"
                    rbFemale.id -> "Female"
                    else -> "Unresolved"
                }
                val birthDate = etBirthDate.text.toString()

                if (name == "" || email == "" || password == "" || gender == "Unresolved" || birthDate == "") {
                    Toast.makeText(this@RegisterActivity, getString(R.string.dialog_invalid_register), Toast.LENGTH_SHORT).show()
                } else if  (password != rePassword) {
                    Toast.makeText(this@RegisterActivity, getString(R.string.dialog_invalid_register_password), Toast.LENGTH_SHORT).show()
                } else {
                    isLoading(true)
                    ApiConfig.getInstance().registerUser(name, email, password, gender, birthDate).enqueue(object : Callback<RegisterResponse> {
                        override fun onResponse(
                            call: Call<RegisterResponse>,
                            response: Response<RegisterResponse>
                        ) {
                            if (response.isSuccessful) {
                                if (response.body()?.data != null) {
                                    userId.add(0, response.body()!!.data.userId)
                                    registerAlert(this@RegisterActivity, getString(R.string.dialog_register_complete_message), userId[0])
                                    sessionManager.saveSession(userId[0], name)
                                    Log.d("Session Saved : ", userId[0])
                                    Log.d("Success : ", response.body()!!.data.toString())
                                }
                            } else {
                                Toast.makeText(this@RegisterActivity, getString(R.string.toast_register_email_exists), Toast.LENGTH_SHORT).show()
                            }
                            Log.d("Data : ", response.body().toString())
                        }

                        override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                            Log.d("Failed: ", t.message.toString())
                        }

                    })
                    isLoading(false)
                }

            }
        }
    }
    private fun isLoading(status: Boolean) {

        binding.btnRegister.isEnabled = !status

    }
}

private fun registerAlert(context: Context, message: String, userId: String) {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.setMessage(message)
    alertDialog.setPositiveButton(context.getString(R.string.dialog_register_complete_positive)) { dialogInterface: DialogInterface, _: Int ->
        val intent = Intent(context, MbtiActivity::class.java)
        intent.putExtra("userId", userId)
        (context as RegisterActivity).startActivity(intent)
        context.finish()
        dialogInterface.dismiss()
    }

    val dialog = alertDialog.create()
    dialog.show()
}
