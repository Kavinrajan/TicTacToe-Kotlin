package kavin.game.tictactoe.model;


import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import static kavin.game.tictactoe.util.StringUtility.isNullOrEmpty;

public class Game {

    private static final String TAG = Game.class.getSimpleName();
    private static final int BOARD_SIZE = 3;

    public Participant participant1;
    public Participant participant2;

    public Participant currentParticipant = participant1;
    public Cell[][] cells;

    public MutableLiveData<Participant> winner = new MutableLiveData<>();

    public Game(String participantOne, String participantTwo) {
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        participant1 = new Participant(participantOne, "I");
        participant2 = new Participant(participantTwo, "U");
        currentParticipant = participant1;
    }

    public boolean hasGameEnded() {
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            winner.setValue(currentParticipant);
            return true;
        }

        if (isBoardFull()) {
            winner.setValue(null);
            return true;
        }

        return false;
    }

    public boolean hasThreeSameHorizontalCells() {
        try {
            for (int i = 0; i < BOARD_SIZE; i++)
                if (areEqual(cells[i][0], cells[i][1], cells[i][2]))
                    return true;

            return false;
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    public boolean hasThreeSameVerticalCells() {
        try {
            for (int i = 0; i < BOARD_SIZE; i++)
                if (areEqual(cells[0][i], cells[1][i], cells[2][i]))
                    return true;
            return false;
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    public boolean hasThreeSameDiagonalCells() {
        try {
            return areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                    areEqual(cells[0][2], cells[1][1], cells[2][0]);
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    //
    public boolean isBoardFull() {
        for (Cell[] row : cells)
            for (Cell cell : row)
                if (cell == null || cell.isEmpty())
                    return false;
        return true;
    }

    //  Two cells are equal if, Both - are none null / have non null valuesboth have equal values
    private boolean areEqual(Cell... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells)
            if (cell == null || isNullOrEmpty(cell.getParticipant().getValue()))
                return false;

        Cell comparisonBase = cells[0];
        for (int i = 1; i < cells.length; i++)
            if (!comparisonBase.getParticipant().getValue().equals(cells[i].getParticipant().getValue()))
                return false;

        return true;
    }

    public void switchParticipant() {
        currentParticipant = currentParticipant == participant1 ? participant2 : participant1;
    }

    public void reset() {
        participant1 = null;
        participant2 = null;
        currentParticipant = null;
        cells = null;
    }
}
