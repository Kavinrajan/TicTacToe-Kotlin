package kavin.game.tictactoe.game


import android.arch.core.executor.testing.InstantTaskExecutorRule
import kavin.game.tictactoe.model.Cell
import kavin.game.tictactoe.model.Game
import kavin.game.tictactoe.model.Participant

import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/*
*  Local Unit test
* */

class SpielTest {

    //  @Rule annotation to property getter , @JvmField - to expose the backing field
    @Rule
    @JvmField
     var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var game: Game
    lateinit private var participant: Participant

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Kavin", "Rajan")
        participant = game.participant1
    }

    @Test
    @Throws(Exception::class)
    fun endSpielIfHasThreeSameHorizontalCells() {
        val cell = Cell(participant)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    @Throws(Exception::class)
    fun endSpielIfHasThreeSameVerticalCells() {
        val cell = Cell(participant)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    @Throws(Exception::class)
    fun endSpielIfHasThreeSameDiagonalCells() {
        val cell = Cell(participant)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }


    @Test
    @Throws(Exception::class)
    fun endSpielIfBoardIsFull() {
        val cell1 = Cell(Participant("1", "i"))
        val cell2 = Cell(Participant("2", "u"))
        val cell3 = Cell(Participant("1", "i"))
        val cell4 = Cell(Participant("2", "u"))
        val cell5 = Cell(Participant("1", "i"))
        val cell6 = Cell(Participant("2", "u"))
        val cell7 = Cell(Participant("1", "i"))
        val cell8 = Cell(Participant("2", "u"))
        val cell9 = Cell(Participant("1", "i"))

        game.cells[0][0] = cell1
        game.cells[0][1] = cell2
        game.cells[0][2] = cell3
        game.cells[1][0] = cell4
        game.cells[1][1] = cell5
        game.cells[1][2] = cell6
        game.cells[2][0] = cell7
        game.cells[2][1] = cell8
        game.cells[2][2] = cell9

        val isBoardFull = game.isBoardFull
        assertTrue(isBoardFull) // Asserts that a condition if board is full or not
    }

    @Test
    @Throws(Exception::class)
    fun switchFromParticipant1ToParticipant2() {
        game.currentParticipant = game.participant1
        game.switchParticipant()
        assertEquals(game.participant2, game.currentParticipant) // conditional check for  two parameter values
    }
}
