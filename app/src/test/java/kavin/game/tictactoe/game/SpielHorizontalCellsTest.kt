package kavin.game.tictactoe.game


import kavin.game.tictactoe.model.Cell
import kavin.game.tictactoe.model.Game
import kavin.game.tictactoe.model.Participant
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

class SpielHorizontalCellsTest {

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
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow1() {
        val cell = Cell(participant)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow2() {
        val cell = Cell(participant)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow3() {
        val cell = Cell(participant)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameHorizontalCells() {
        val cell = Cell(participant)
        val anotherCell = Cell(anotherParticipant)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = anotherCell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertFalse(hasThreeSameHorizontalCells)
    }
}
