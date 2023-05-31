package com.bayutb.gombti.ui.register

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bayutb.gombti.databinding.ActivityRegisterBinding
import com.bayutb.gombti.ui.login.LoginActivity
import com.bayutb.gombti.ui.mbti.MbtiActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            etBirthDate.showSoftInputOnFocus = false
            etBirthDate.setOnClickListener {

                val c = Calendar.getInstance()

                val year = c.get(Calendar.YEAR)
                val month  = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val datePickerDialog = DatePickerDialog(
                    this@RegisterActivity,
                    { _, _year, _monthOfYear, _dayOfMonth ->
                        // on below line we are setting
                        // date to our edit text.
                        val dat = (_dayOfMonth.toString() + "-" + (_monthOfYear + 1) + "-" + _year)
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
                Intent(this@RegisterActivity, MbtiActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}