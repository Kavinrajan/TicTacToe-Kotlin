package kavin.game.tictactoe

import android.support.test.rule.ActivityTestRule

import org.junit.Rule
import org.junit.Test

import kavin.game.tictactoe.view.SpielActivity

import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import kavin.game.tictactoe.model.Participant

/**
 * Created by kavinrajan on 6/1/20.
 */

class SpielEndeDialogUITest {


    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SpielActivity>(SpielActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun display_winner_when_spiel_ends() {

        givenSpielEnded()

        // assign end message to view, displayed = #Barista’s Assertions API
        assertDisplayed(R.id.tv_winner)
    }

    @Test
    @Throws(Exception::class)
    fun display_start_dialog_when_done_clicked() {
        givenSpielEnded()

        // interact with dialogs = Promp buttonn click
        clickDialogPositiveButton()

        // view doesn't exist
        assertNotExist(R.id.tv_winner)
        assertDisplayed(R.id.et_participant1)
    }

    // show dialog for Spiel Game Result
    private fun givenSpielEnded() {
        activityRule.activity.onSpielWinnerChanged(Participant("rajan", "u"))
    }
}