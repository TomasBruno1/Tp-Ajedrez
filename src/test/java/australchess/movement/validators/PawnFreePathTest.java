package australchess.movement.validators;

import australchess.cli.Board;
import australchess.factories.BoardFactory;
import australchess.factories.DefaultBoardFactory;
import australchess.factories.DefaultPieceSetFactory;
import australchess.factories.PieceSetFactory;
import australchess.movement.BoardMovement;
import australchess.movement.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnFreePathTest {
    PawnFreePath pawnFreePath = new PawnFreePath();
    BoardFactory boardFactory = new DefaultBoardFactory();
    PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    Board board = boardFactory.createBoard(pieceSetFactory.createPieceSet("white"), pieceSetFactory.createPieceSet("black"));

    @Test
    void Test001_PawnFreePathShouldReturnTrueIfThereIsNoPieceOnPath() {
        assertTrue(pawnFreePath.test(new BoardMovement(board, new Movement(board.getPosition(1,'b'), board.getPosition(1,'d')))));
    }

    @Test
    void Test002_PawnFreePathShouldReturnFalseIfThereIsAPieceOnPath() {
        assertFalse(pawnFreePath.test(new BoardMovement(board, new Movement(board.getPosition(1,'a'), board.getPosition(1,'c')))));
    }
}