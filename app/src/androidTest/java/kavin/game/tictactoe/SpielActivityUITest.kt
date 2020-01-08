package kavin.game.tictactoe

import android.support.test.rule.ActivityTestRule

import org.junit.Rule
import org.junit.Test

import kavin.game.tictactoe.model.Participant
import kavin.game.tictactoe.view.SpielActivity

import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo

/**
 * Created by kavinrajan on 6/1/20.
 */

class SpielActivityUITest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(SpielActivity::class.java)

    private val participant1 = Participant("Participant I", "i")
    private val participant2 = Participant("Participant U", "u")

    @Test
    fun end_game_when_one_Participant_wins() {

        // writing into input widgets = input participant name
        writeTo(R.id.et_participant1, participant1.name)
        writeTo(R.id.et_participant2, participant2.name)

        // interact with dialogs = Promp buttonn click
        clickDialogPositiveButton()

        // click widgets = Layout Cell
        clickOn(R.id.cell_00)
        clickOn(R.id.cell_10)
        clickOn(R.id.cell_01)
        clickOn(R.id.cell_11)
        clickOn(R.id.cell_02)

        // assign winner name to view, displayed = #Barista’s Assertions API
        assertDisplayed(R.id.tv_winner)
        assertDisplayed(participant1.name)

    }
}
