package kavin.game.tictactoe

import android.support.test.rule.ActivityTestRule

import org.junit.Rule
import org.junit.Test

import kavin.game.tictactoe.view.SpielActivity

import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo

class SpielStartDialogUITest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SpielActivity>(SpielActivity::class.java)

    // Input field validation, display error message
    @Test
    @Throws(Exception::class)
    fun display_empty_names_message_if_names_empty() {
        writeTo(R.id.et_participant1, "")
        writeTo(R.id.et_participant2, "")

        clickDialogPositiveButton()

        assertDisplayed(R.string.spiel_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun display_same_names_message_if_names_same() {

        writeTo(R.id.et_participant1, "Participant 1")
        writeTo(R.id.et_participant2, "Participant 1")

        clickDialogPositiveButton()

        assertDisplayed(R.string.spiel_dialog_same_names)
    }

    @Test
    @Throws(Exception::class)
    fun display_empty_name_message_if_one_name_empty() {
        writeTo(R.id.et_participant1, "")
        writeTo(R.id.et_participant2, "rajan")

        clickDialogPositiveButton()

        assertDisplayed(R.string.spiel_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun close_dialog_after_names_valid() {
        writeTo(R.id.et_participant1, "Kavin I")
        writeTo(R.id.et_participant2, "Rajan U")

        clickDialogPositiveButton()

        assertNotExist(R.id.lt_participant1)
    }
}
