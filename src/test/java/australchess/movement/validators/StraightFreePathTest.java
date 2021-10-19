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

class StraightFreePathTest {
    StraightFreePath straightFreePath = new StraightFreePath();
    BoardFactory boardFactory = new DefaultBoardFactory();
    PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    Board board = boardFactory.createBoard(pieceSetFactory.createPieceSet("white"), pieceSetFactory.createPieceSet("black"));

    @Test
    void Test001_StraightFreePathShouldReturnTrueIfThereIsNoPieceOnPath() {
        assertTrue(straightFreePath.test(new BoardMovement(board, new Movement(board.getPosition(4,'d'), board.getPosition(8,'d')))));
    }

    @Test
    void Test002_StraightFreePathShouldReturnFalseIfThereIsAPieceOnPath() {
        assertFalse(straightFreePath.test(new BoardMovement(board, new Movement(board.getPosition(2,'b'), board.getPosition(4,'b')))));
    }

    @Test
    void Test003_StraightFreePathShouldReturnFalseIfMovementIsNotStraight() {
        assertFalse(straightFreePath.test(new BoardMovement(board, new Movement(board.getPosition(3,'a'), board.getPosition(6,'d')))));
    }
}