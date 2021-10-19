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

class TargetSquareTest {
    TargetSquare targetSquare = new TargetSquare();
    BoardFactory boardFactory = new DefaultBoardFactory();
    PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    Board board = boardFactory.createBoard(pieceSetFactory.createPieceSet("white"), pieceSetFactory.createPieceSet("black"));

    @Test
    void Test001_TargetSquareShouldReturnTrueIfThereIsNoPieceOnTargetSquare() {
        assertTrue(targetSquare.test(new BoardMovement(board, new Movement(board.getPosition(1,'b'), board.getPosition(1,'d')))));
    }

    @Test
    void Test002_TargetSquareShouldReturnFalseIfThereIsAPieceOfSameColorOnTargetSquare() {
        assertFalse(targetSquare.test(new BoardMovement(board, new Movement(board.getPosition(1,'a'), board.getPosition(1,'b')))));
    }

    @Test
    void Test003_TargetSquareShouldReturnTrueIfThereIsAPieceOfDifferentColorOnTargetSquare() {
        assertTrue(targetSquare.test(new BoardMovement(board, new Movement(board.getPosition(1,'b'), board.getPosition(1,'g')))));
    }

}