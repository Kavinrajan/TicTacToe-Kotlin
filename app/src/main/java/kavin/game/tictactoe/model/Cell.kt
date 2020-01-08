package kavin.game.tictactoe.model


import kavin.game.tictactoe.util.StringUtility.isNullOrEmpty

class Cell(var participant: Participant?) {

    val isEmpty: Boolean
        get() = participant == null || isNullOrEmpty(participant!!.value)
}
