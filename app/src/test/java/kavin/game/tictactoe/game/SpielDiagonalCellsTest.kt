package kavin.game.tictactoe.game


import kavin.game.tictactoe.model.Cell
import kavin.game.tictactoe.model.Game
import kavin.game.tictactoe.model.Participant
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

class SpielDiagonalCellsTest {

    lateinit private var game: Game
    lateinit private var participant: Participant
    lateinit private var anotherParticipant: Participant

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Kavin", "Rajan")
        participant = game.participant1
        anotherParticipant = game.participant2
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromLeft() {
        val cell = Cell(participant)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromRight() {
        val cell = Cell(participant)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameDiagonalCells() {
        val cell = Cell(participant)
        val anotherCell = Cell(anotherParticipant)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = anotherCell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertFalse(hasThreeSameDiagonalCells)
    }
}
