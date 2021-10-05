package australchess.pieces;

import australchess.cli.BoardPosition;
import australchess.movement.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    King king = new King("white");

    @Test
    void Test001_KingCanMoveToAllItsNeighbouringPositions() {
        BoardPosition kingPosition = new BoardPosition(king, 2, 'b');

        for (int i = 1; i <= 3 ; i++) {
            for (int j = 'a'; j <= 'c' ; j++) {
                if(i == 2 && j == 'b') continue;
                BoardPosition emptyPosition = new BoardPosition(null, i, (char) j);
                assertTrue(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));
            }
        }
    }

    @Test
    void Test002_KingCanMoveMoreThanOnePositionOnItsFileAsAnAttemptToCastleIfItHasNotMoved() {
        BoardPosition kingPosition = new BoardPosition(king, 5, 'a');
        BoardPosition emptyPosition = new BoardPosition(null, 2,'a');

        assertTrue(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 7, 'a');

        assertTrue(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));
    }

    @Test
    void Test003_IfTheKingHasMovedThenItCannotMoveMoreThanOnePositionOnAnyDirection() {
        king.setMoved(true);

        BoardPosition kingPosition = new BoardPosition(king, 3, 'c');
        BoardPosition emptyPosition = new BoardPosition(null, 3,'a');

        assertFalse(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 7, 'c');

        assertFalse(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 3, 'e');

        assertFalse(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 1, 'a');

        assertFalse(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 5, 'e');

        assertFalse(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 7, 'a');

        assertFalse(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 6, 'c');

        assertFalse(kingPosition.getPiece().isLegalMovement(new Movement(kingPosition, emptyPosition)));
    }

}