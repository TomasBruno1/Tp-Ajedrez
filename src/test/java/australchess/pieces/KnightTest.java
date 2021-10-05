package australchess.pieces;

import australchess.cli.BoardPosition;
import australchess.movement.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    Knight knight = new Knight("white");
    BoardPosition knightPosition = new BoardPosition(knight, 3, 'c');

    @Test
    void Test001_KnightCanMoveTwoPositionsOnOneDirectionAndOneOnTheOther() {
        BoardPosition emptyPosition = new BoardPosition(null, 2, 'a');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 1, 'b');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 1, 'd');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 2, 'e');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 4, 'e');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 5, 'd');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 5, 'b');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 4, 'a');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 2, 'a');
        assertTrue(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));
    }

    @Test
    void Test002_KnightCannotMoveOnStraightLinesOrDiagonally() {
        BoardPosition emptyPosition = new BoardPosition(null, 5, 'c');
        assertFalse(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 1, 'e');
        assertFalse(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 2, 'f');
        assertFalse(knight.isLegalMovement(new Movement(knightPosition, emptyPosition)));
    }
}