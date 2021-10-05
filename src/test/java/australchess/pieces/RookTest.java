package australchess.pieces;

import australchess.cli.BoardPosition;
import australchess.movement.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    Rook rook = new Rook("white");

    @Test
    void Test001_RookCanMoveBetweenTwoBoardPositionsOnTheSameRow() {

        BoardPosition rookPosition = new BoardPosition(rook, 1, 'a');
        BoardPosition emptyPosition = new BoardPosition(null, 5, 'a');

        assertTrue(rookPosition.getPiece().isLegalMovement(new Movement(rookPosition, emptyPosition)));

        rookPosition = new BoardPosition(rook, 5, 'a');
        emptyPosition = new BoardPosition(null, 1, 'a');

        assertTrue(rookPosition.getPiece().isLegalMovement(new Movement(rookPosition, emptyPosition)));
    }

    @Test
    void Test002_RookCanMoveBetweenTwoBoardPositionsOnTheSameFile() {
        BoardPosition rookPosition = new BoardPosition(rook, 1, 'a');
        BoardPosition emptyPosition = new BoardPosition(null, 1, 'd');

        assertTrue(rookPosition.getPiece().isLegalMovement(new Movement(rookPosition, emptyPosition)));

        rookPosition = new BoardPosition(rook, 1, 'd');
        emptyPosition = new BoardPosition(null, 1, 'a');

        assertTrue(rookPosition.getPiece().isLegalMovement(new Movement(rookPosition, emptyPosition)));
    }

    @Test
    void Test003_RookCannotMoveBetweenTwoBoardPositionsWithDifferentRowAndFile() {
        BoardPosition rookPosition = new BoardPosition(rook, 1, 'c');
        BoardPosition emptyPosition = new BoardPosition(null, 3, 'a');

        assertFalse(rookPosition.getPiece().isLegalMovement(new Movement(rookPosition, emptyPosition)));

        rookPosition = new BoardPosition(rook, 3, 'a');
        emptyPosition = new BoardPosition(null, 1, 'c');

        assertFalse(rookPosition.getPiece().isLegalMovement(new Movement(rookPosition, emptyPosition)));
    }

}