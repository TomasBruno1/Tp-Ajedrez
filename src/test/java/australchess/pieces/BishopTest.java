package australchess.pieces;

import australchess.cli.BoardPosition;
import australchess.movement.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    Bishop bishop = new Bishop("white");
    BoardPosition bishopPosition = new BoardPosition(bishop, 3, 'c');

    @Test
    void Test001_BishopCanMoveDiagonallyBetweenTwoBoardPositionsOnAnyDirection() {
        BoardPosition emptyPosition = new BoardPosition(null, 1, 'a');

        assertTrue(bishopPosition.getPiece().isLegalMovement(new Movement(bishopPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 1, 'e');

        assertTrue(bishopPosition.getPiece().isLegalMovement(new Movement(bishopPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 5, 'e');

        assertTrue(bishopPosition.getPiece().isLegalMovement(new Movement(bishopPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 5, 'a');

        assertTrue(bishopPosition.getPiece().isLegalMovement(new Movement(bishopPosition, emptyPosition)));
    }


    @Test
    void Test002_BishopCannotMoveOnStraightLinesBetweenTwoBoardPositions() {
        BoardPosition emptyPosition = new BoardPosition(null, 3, 'a');

        assertFalse(bishopPosition.getPiece().isLegalMovement(new Movement(bishopPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 1, 'c');

        assertFalse(bishopPosition.getPiece().isLegalMovement(new Movement(bishopPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 4, 'c');

        assertFalse(bishopPosition.getPiece().isLegalMovement(new Movement(bishopPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 3, 'd');

        assertFalse(bishopPosition.getPiece().isLegalMovement(new Movement(bishopPosition, emptyPosition)));
    }
}