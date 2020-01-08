package kavin.game.tictactoe;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import kavin.game.tictactoe.model.Participant;
import kavin.game.tictactoe.view.SpielActivity;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.*;
import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;

public class SpielActivityShould {

    @Rule
    public ActivityTestRule<SpielActivity> activityRule = new ActivityTestRule<>(SpielActivity.class);

    private Participant participant1 = new Participant("Participant I", "i");
    private Participant participant2 = new Participant("Participant U", "u");

    @Test
    public void end_game_when_one_Participant_wins() {

        // writing into input widgets = input participant name
        writeTo(R.id.et_participant1, participant1.getName());
        writeTo(R.id.et_participant2, participant2.getName());

        // interact with dialogs = Promp buttonn click
        clickDialogPositiveButton();

        // click widgets = Layout Cell
        clickOn(R.id.cell_00);
        clickOn(R.id.cell_10);
        clickOn(R.id.cell_01);
        clickOn(R.id.cell_11);
        clickOn(R.id.cell_02);

        // assign winner name to view, displayed = #Barista’s Assertions API
        assertDisplayed(R.id.tv_winner);
        assertDisplayed(participant1.getName());

    }
}
