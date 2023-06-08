package com.bayutb.gombti.ui.register

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.bayutb.gombti.R
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
            checkPassword(etPassword, etRePassword, btnRegister)
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
                val fullName = etFullName.text.toString()
                val emailAddress = etEmailAddress.text.toString()
                val password = etPassword.text.toString()
                val gender = when (rgGender.checkedRadioButtonId) {
                    rbMale.id -> "Male"
                    rbFemale.id -> "Female"
                    else -> "Unresolved"
                }
                val birthDate = etBirthDate.text.toString()

                // CHECK COLUMN SUDAH DIISI APA BELUM
                if (fullName == "" || emailAddress == "" || password == "" || gender == "Unresolved" || birthDate == "") {
                    showAlert(this@RegisterActivity)
                } else {
                    /*
                   PROSES TEMBAK API ENDPOINT
                   */

                    // PASSING USER ID KE MBTI ACTIVITY
                    val userId = 1 // GET RESPONSE DARI ENDPOINT REGISTER
                    val intent = Intent(this@RegisterActivity, MbtiActivity::class.java)
                    intent.putExtra("userId", userId)
                    startActivity(intent)
                }
            }
        }
    }
}

private fun checkPassword(etPassword: EditText, etRePassword: EditText, btnRegister : Button) {

    etPassword.addTextChangedListener {
        btnRegister.isEnabled = etPassword.text.toString() == etRePassword.text.toString()
    }
    etRePassword.addTextChangedListener {
        btnRegister.isEnabled = etPassword.text.toString() == etRePassword.text.toString()
    }

}

private fun showAlert(context: Context) {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.setMessage(R.string.dialog_invalid_register)
    alertDialog.setPositiveButton(context.getString(R.string.dialog_invalid_register_positive)) { dialogInterface: DialogInterface, _: Int ->
        dialogInterface.dismiss()
    }

    val dialog = alertDialog.create()
    dialog.show()
}