package australchess.pieces;

import australchess.cli.BoardPosition;
import australchess.movement.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    Pawn whitePawn = new Pawn("white");
    Pawn blackPawn = new Pawn("black");
    BoardPosition whitePawnPosition = new BoardPosition(whitePawn, 1, 'b');
    BoardPosition blackPawnPosition = new BoardPosition(blackPawn, 1, 'g');

    @Test
    void Test001_WhitePawnMovesUpwardsOnePosition() {
        BoardPosition emptyPosition = new BoardPosition(null, 1, 'c');
        assertTrue(whitePawn.isLegalMovement(new Movement(whitePawnPosition, emptyPosition)));
    }

    @Test
    void Test002_WhitePawnCanMoveUpwardsTwoPositionsIfItHasNotMoved() {
        BoardPosition emptyPosition = new BoardPosition(null, 1, 'd');
        assertTrue(whitePawn.isLegalMovement(new Movement(whitePawnPosition, emptyPosition)));

        whitePawn.setMoved(true);
        assertFalse(whitePawn.isLegalMovement(new Movement(whitePawnPosition, emptyPosition)));
    }

    @Test
    void Test003_WhitePawnCanMoveDiagonallyUpwardsOnePositionAsAnAttemptToTakeAnotherPieceRegardlessOfItsColor() {
        BoardPosition rookPosition = new BoardPosition(new Rook("black"), 0, 'c');
        assertTrue(whitePawn.isLegalMovement(new Movement(whitePawnPosition, rookPosition)));

        rookPosition = new BoardPosition(new Rook("white"), 2, 'c');
        assertTrue(whitePawn.isLegalMovement(new Movement(whitePawnPosition, rookPosition)));
    }

    @Test
    void Test004_WhitePawnCannotMoveDownwards() {
        BoardPosition emptyPosition = new BoardPosition(null, 1, 'a');
        assertFalse(whitePawn.isLegalMovement(new Movement(whitePawnPosition, emptyPosition)));
    }

    @Test
    void Test005_BlackPawnMovesDownwardsOnePosition() {
        BoardPosition emptyPosition = new BoardPosition(null, 1, 'f');
        assertTrue(blackPawn.isLegalMovement(new Movement(blackPawnPosition, emptyPosition)));
    }

    @Test
    void Test006_BlackPawnCanMoveDownwardsTwoPositionsIfItHasNotMoved() {
        BoardPosition emptyPosition = new BoardPosition(null, 1, 'e');
        assertTrue(blackPawn.isLegalMovement(new Movement(blackPawnPosition, emptyPosition)));

        blackPawn.setMoved(true);
        assertFalse(blackPawn.isLegalMovement(new Movement(blackPawnPosition, emptyPosition)));
    }

    @Test
    void Test007_BlackPawnCanMoveDiagonallyDownwardsOnePositionAsAnAttemptToTakeAnotherPieceRegardlessOfItsColor() {
        BoardPosition rookPosition = new BoardPosition(new Rook("black"), 0, 'f');
        assertTrue(blackPawn.isLegalMovement(new Movement(blackPawnPosition, rookPosition)));

        rookPosition = new BoardPosition(new Rook("white"), 2, 'f');
        assertTrue(blackPawn.isLegalMovement(new Movement(blackPawnPosition, rookPosition)));
    }

    @Test
    void Test008_BlackPawnCannotMoveUpwards() {
        BoardPosition emptyPosition = new BoardPosition(null, 1, 'h');
        assertFalse(blackPawn.isLegalMovement(new Movement(blackPawnPosition, emptyPosition)));
    }

}