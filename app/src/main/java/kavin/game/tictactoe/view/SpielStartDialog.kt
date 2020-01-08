package kavin.game.tictactoe.view


import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View

import kavin.game.tictactoe.R
import kotlinx.android.synthetic.main.spiel_start_dialog.view.*

class SpielStartDialog : DialogFragment() {


    lateinit private var activity: SpielActivity
    private var participant1: String? = null
    private var participant2: String? = null
    private var rv: View? = null     // root view

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        initViews()

        val alertDg = AlertDialog.Builder(context!!)
                .setView(rv)
                .setTitle(R.string.spiel_dialog_title)
                .setCancelable(false)
                .setPositiveButton(R.string.done, null)
                .create()
        alertDg.setCanceledOnTouchOutside(false)
        alertDg.setCancelable(false)
        alertDg.setOnShowListener { dialog -> onDialogShow(alertDg) }
        return alertDg
    }

    private fun initViews() {
        rv = LayoutInflater.from(context)
                .inflate(R.layout.spiel_start_dialog, null, false)


        addTextWatchers()
    }

    private fun onDialogShow(dialog: AlertDialog) {
        val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        positiveButton.setOnClickListener { v -> onDoneClicked() }
    }

    // After
    private fun onDoneClicked() {
        if (isValidName(rv!!.lt_participant1, participant1) and isValidName(rv!!.lt_participant2, participant2)) {
            activity.onParticipantsSet(participant1!!, participant2!!)
            dismiss()
        }
    }

    private fun isValidName(layout: TextInputLayout?, name: String?): Boolean {
        if (TextUtils.isEmpty(name)) {
            layout!!.isErrorEnabled = true
            layout.error = getString(R.string.spiel_dialog_empty_name)
            return false
        }

        if (participant1 != null && participant2 != null && participant1!!.equals(participant2!!, ignoreCase = true)) {
            layout!!.isErrorEnabled = true
            layout.error = getString(R.string.spiel_dialog_same_names)
            return false
        }

        layout!!.isErrorEnabled = false
        layout.error = ""
        return true
    }

    private fun addTextWatchers() {
        rv!!.et_participant1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                participant1 = s.toString()
            }
        })
        rv!!.et_participant2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                participant2 = s.toString()
            }
        })
    }

    companion object {

        fun newInstance(activity: SpielActivity): SpielStartDialog {
            val dialog = SpielStartDialog()
            dialog.activity = activity
            return dialog
        }
    }
}
