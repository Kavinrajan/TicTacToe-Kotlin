package kavin.game.tictactoe;

import android.support.test.rule.ActivityTestRule;

import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions;

import org.junit.Rule;
import org.junit.Test;

import kavin.game.tictactoe.model.Participant;
import kavin.game.tictactoe.view.SpielActivity;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;

/**
 * Created by kavinrajan on 6/1/20.
 */
public class SpielEndeDialogShould {


    @Rule
    public ActivityTestRule<SpielActivity> activityRule = new ActivityTestRule<>(SpielActivity.class);

    @Test
    public void display_winner_when_game_ends() throws Exception {
        givenSpielEnded();

        // assign end message to view, displayed = #Barista’s Assertions API
        BaristaVisibilityAssertions.assertDisplayed(R.id.tv_winner);
    }

    @Test
    public void display_begin_dialog_when_done_clicked() throws Exception {
        givenSpielEnded();

        // interact with dialogs = Promp buttonn click
        clickDialogPositiveButton();

        // view doesn't exist
        assertNotExist(R.id.tv_winner);
        assertDisplayed(R.id.et_participant1);
    }

    // show dialog for Spiel Game Result
    private void givenSpielEnded() {
        activityRule.getActivity().onSpielWinnerChanged(new Participant("rajan", "u"));
    }
}