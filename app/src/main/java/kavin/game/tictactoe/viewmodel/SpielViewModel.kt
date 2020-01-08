package kavin.game.tictactoe.viewmodel


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayMap
import kavin.game.tictactoe.model.Cell
import kavin.game.tictactoe.model.Game
import kavin.game.tictactoe.model.Participant

import kavin.game.tictactoe.util.StringUtility.stringFromNumbers

class SpielViewModel : ViewModel() {

    lateinit var cells: ObservableArrayMap<String, String>
    lateinit private var game: Game

    // notify views
    val winner: LiveData<Participant>
        get() = game.winner

    fun init(participant1: String, participant2: String) {
        game = Game(participant1, participant2)
        cells = ObservableArrayMap()
    }

    // binded Cell click event method
    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = Cell(game.currentParticipant)
            cells[stringFromNumbers(row, column)] = game.currentParticipant.value
            if (game.hasGameEnded())
                game.reset()
            else
                game.switchParticipant()
        }
    }
}
