package com.bayutb.gombti.ui.main

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bayutb.gombti.MainActivity
import com.bayutb.gombti.R
import com.bayutb.gombti.databinding.FragmentAccountBinding
import com.bayutb.gombti.model.LoginSession

@Suppress("DEPRECATION")
class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private lateinit var userData : ArrayList<LoginSession>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userData = arguments?.getParcelableArrayList("session")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        binding.apply {
            btnLogout.setOnClickListener {
                showAlert(requireActivity())
            }
            tvEmailAddress.text = userData[0].email
            tvFullName.text = userData[0].name
        }

        return binding.root
    }

}

private fun showAlert(context: FragmentActivity) {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.setMessage(context.getString(R.string.dialog_logout_question))
    alertDialog.setPositiveButton(context.getString(R.string.dialog_logout_positive)) { dialogInterface: DialogInterface, _: Int ->
        (context as MainActivity).logout()
        dialogInterface.dismiss()
    }

    alertDialog.setNegativeButton(context.getString(R.string.dialog_logout_negative)) { dialogInterface: DialogInterface, _: Int ->
        dialogInterface.dismiss()
    }

    val dialog = alertDialog.create()
    dialog.show()
}