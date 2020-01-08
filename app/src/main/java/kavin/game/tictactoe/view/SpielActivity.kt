package kavin.game.tictactoe.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity

import kavin.game.tictactoe.R
import kavin.game.tictactoe.databinding.ActivitySpielBinding
import kavin.game.tictactoe.model.Participant
import kavin.game.tictactoe.viewmodel.SpielViewModel

import kavin.game.tictactoe.util.StringUtility.isNullOrEmpty

class SpielActivity : AppCompatActivity() {
    // must intilize later
    lateinit private var spiel_viewmodel: SpielViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        participantsEntry()

    }

    // show dialog to enter participants
    fun participantsEntry() {
        val dialog = SpielStartDialog.newInstance(this)
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, SPIEL_START_DIALOG_TAG)
    }

    fun onParticipantsSet(participant1: String, participant2: String) {
        initDataBinding(participant1, participant2)
    }

    private fun initDataBinding(participant1: String, participant2: String) {

        val activitySpielBinding = DataBindingUtil.setContentView<ActivitySpielBinding>(this, R.layout.activity_spiel)

        // stores UI-related data and that isn't destroyed on app rotations
        // to get Game/Spiel ViewModel.
        spiel_viewmodel = ViewModelProviders.of(this).get(SpielViewModel::class.java)
        spiel_viewmodel.init(participant1, participant2)

        activitySpielBinding.spielViewModel = spiel_viewmodel
        setSpielEndListener()

    }

    // subscribes the Observer object to the LiveData object so that it is notified of changes.
    private fun setSpielEndListener() {
        spiel_viewmodel.winner.observe(this,
               // observer which updates the UI.
                Observer<Participant> {
                    // Update the UI, in this case, Result on a Dialog.
                    this.onSpielWinnerChanged(it)
                }
        )

    }


    @VisibleForTesting  //  to make code testable. ( this package is part of the android support library )
    fun onSpielWinnerChanged(winner: Participant?) {
        val winner_name= if (winner == null || isNullOrEmpty(winner.name)) NO_WINNER
        else winner.name

        val dialog = SpielEndeDialog.newInstance(this, winner_name)
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, SPIEL_ENDE_DIALOG_TAG)

    }

    companion object {
        private val SPIEL_START_DIALOG_TAG = "spiel_dialog_tag"
        private val SPIEL_ENDE_DIALOG_TAG = "spiel_end_dialog_tag"
        private val NO_WINNER = "Game Drawn"
    }
}
