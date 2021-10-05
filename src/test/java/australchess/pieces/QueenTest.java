package australchess.pieces;

import australchess.cli.BoardPosition;
import australchess.movement.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    Queen queen = new Queen("white");
    BoardPosition queenPosition = new BoardPosition(queen, 4, 'd');

    @Test
    void Test001_QueenCanMoveDiagonallyOnAnyDirectionAnyAmountOfPositions() {
        int number = 4;
        int letter = 'd';

        for (int i = -3; i <= 4; i++) {
            if(i == 0) continue;
            BoardPosition emptyPosition = new BoardPosition(null, number + i, (char) (letter + i));
            assertTrue(queen.isLegalMovement(new Movement(queenPosition, emptyPosition)));
        }

        for (int i = -3; i <= 4; i++) {
            if(i == 0) continue;
            BoardPosition emptyPosition = new BoardPosition(null, number - i, (char) (letter + i));
            assertTrue(queen.isLegalMovement(new Movement(queenPosition, emptyPosition)));
        }
    }

    @Test
    void Test002_QueenCanMoveOnAStraightLineOnAnyDirectionAnyAmountOfPositions() {
        int number = 4;
        int letter = 'd';

        for (int i = -3; i <= 4; i++) {
            if(i == 0) continue;
            BoardPosition emptyPosition = new BoardPosition(null, number + i, (char) letter);
            assertTrue(queen.isLegalMovement(new Movement(queenPosition, emptyPosition)));
        }

        for (int i = -3; i <= 4; i++) {
            if(i == 0) continue;
            BoardPosition emptyPosition = new BoardPosition(null, number, (char) (letter + i));
            assertTrue(queen.isLegalMovement(new Movement(queenPosition, emptyPosition)));
        }
    }

    @Test
    void Test003_QueenCannotMoveAsAKnightDoes() {
        queenPosition = new BoardPosition(queen, 3, 'c');

        BoardPosition emptyPosition = new BoardPosition(null, 2, 'a');
        assertFalse(queen.isLegalMovement(new Movement(queenPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 1, 'b');
        assertFalse(queen.isLegalMovement(new Movement(queenPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 1, 'd');
        assertFalse(queen.isLegalMovement(new Movement(queenPosition, emptyPosition)));

        emptyPosition = new BoardPosition(null, 2, 'e');
        assertFalse(queen.isLegalMovement(new Movement(queenPosition, emptyPosition)));
    }

}