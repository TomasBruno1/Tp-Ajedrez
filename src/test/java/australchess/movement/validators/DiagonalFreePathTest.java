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

class DiagonalFreePathTest {
    DiagonalFreePath diagonalFreePath = new DiagonalFreePath();
    BoardFactory boardFactory = new DefaultBoardFactory();
    PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    Board board = boardFactory.createBoard(pieceSetFactory.createPieceSet("white"), pieceSetFactory.createPieceSet("black"));

    @Test
    void Test001_DiagonalFreePathShouldReturnTrueIfThereIsNoPieceOnPath() {
        assertTrue(diagonalFreePath.test(new BoardMovement(board, new Movement(board.getPosition(1,'c'), board.getPosition(3,'e')))));
    }

    @Test
    void Test002_DiagonalFreePathShouldReturnFalseIfThereIsAPieceOnPath() {
        assertFalse(diagonalFreePath.test(new BoardMovement(board, new Movement(board.getPosition(1,'a'), board.getPosition(3,'c')))));
    }

    @Test
    void Test003_DiagonalFreePathShouldReturnFalseIfMovementIsNotDiagonal() {
        assertFalse(diagonalFreePath.test(new BoardMovement(board, new Movement(board.getPosition(3,'c'), board.getPosition(3,'e')))));
    }
}