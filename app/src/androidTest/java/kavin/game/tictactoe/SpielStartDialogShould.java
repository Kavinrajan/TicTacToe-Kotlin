package kavin.game.tictactoe;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import kavin.game.tictactoe.view.SpielActivity;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;

public class SpielStartDialogShould {

    @Rule
    public ActivityTestRule<SpielActivity> activityRule = new ActivityTestRule<>(SpielActivity.class);

    // Input field validation, display error message
    @Test
    public void display_empty_names_message_if_names_empty() throws Exception {
        writeTo(R.id.et_participant1, "");
        writeTo(R.id.et_participant2, "");

        clickDialogPositiveButton();

        assertDisplayed(R.string.spiel_dialog_empty_name);
    }

    @Test
    public void display_same_names_message_if_names_same() throws Exception {
        writeTo(R.id.et_participant1, "kavin");
        writeTo(R.id.et_participant2, "kavin");

        clickDialogPositiveButton();

        assertDisplayed(R.string.spiel_dialog_same_names);
    }

    @Test
    public void display_empty_name_message_if_one_name_empty() throws Exception {
        writeTo(R.id.et_participant1, "");
        writeTo(R.id.et_participant2, "rajan");

        clickDialogPositiveButton();

        assertDisplayed(R.string.spiel_dialog_empty_name);
    }

    @Test
    public void close_dialog_after_names_valid() throws Exception {
        writeTo(R.id.et_participant1, "Kavin I");
        writeTo(R.id.et_participant2, "Rajan U");

        clickDialogPositiveButton();

        assertNotExist(R.id.lt_participant1);
    }
}
