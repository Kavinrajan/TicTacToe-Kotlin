package kavin.game.tictactoe.game


import kavin.game.tictactoe.model.Cell
import kavin.game.tictactoe.model.Game
import kavin.game.tictactoe.model.Participant
import org.junit.Before
import org.junit.Test

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

class SpielVerticalCellsTest {

    lateinit var game: Game
    lateinit private var participant: Participant
    lateinit private var anotherParticipant: Participant

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Kavin I", "Rajan U")
        participant = game.participant1
        anotherParticipant = game.participant2
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn1() {
        val cell = Cell(participant)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn2() {
        val cell = Cell(participant)
        game.cells[0][1] = cell
        game.cells[1][1] = cell
        game.cells[2][1] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn3() {
        val cell = Cell(participant)
        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameVerticalCells() {
        val cell = Cell(participant)
        val anotherCell = Cell(anotherParticipant)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = anotherCell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertFalse(hasThreeSameVerticalCells)
    }
}
