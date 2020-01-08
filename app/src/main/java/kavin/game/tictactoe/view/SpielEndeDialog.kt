package kavin.game.tictactoe.view


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

import kavin.game.tictactoe.R
import kotlinx.android.synthetic.main.spiel_ende_dialog.view.*
import java.util.*
import kotlin.concurrent.schedule

class SpielEndeDialog : DialogFragment() {

    lateinit private var activity: SpielActivity

    private var rv: View? = null // root view
    private var winnerName: String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initViews()


        val alertDg= AlertDialog.Builder(context!!)
                .setView(rv)
                .setCancelable(false)
                .setPositiveButton(R.string.done) {  dialog, which -> newEntry() }
                .create()
        alertDg.setCanceledOnTouchOutside(false)
        alertDg.setCancelable(false)
        return alertDg
    }

    private fun initViews() {
        rv = LayoutInflater.from(context).inflate(R.layout.spiel_ende_dialog, null, false)
        (rv!!.tv_winner).text = winnerName
    }

    private fun newEntry() {
        dismiss()
        Timer("Call Entry for Participants Entry", false).schedule(500) {
            activity.participantsEntry()
        }
    }

    // decler static members
    companion object {

        fun newInstance(activity: SpielActivity, winnerName: String): SpielEndeDialog {
            val dg = SpielEndeDialog()
            dg.activity = activity
            dg.winnerName = winnerName
            return dg
        }
    }
}
