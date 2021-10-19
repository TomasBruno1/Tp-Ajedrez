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

class OrFreePathTest {
    OrFreePath orFreePath = new OrFreePath(new StraightFreePath(), new DiagonalFreePath());
    BoardFactory boardFactory = new DefaultBoardFactory();
    PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    Board board = boardFactory.createBoard(pieceSetFactory.createPieceSet("white"), pieceSetFactory.createPieceSet("black"));

    @Test
    void Test001_OrFreePathShouldReturnTrueIfOneValidatorReturnsTrue() {
        assertTrue(orFreePath.test(new BoardMovement(board, new Movement(board.getPosition(1,'b'), board.getPosition(3,'d')))));
    }

    @Test
    void Test002_OrFreePathShouldReturnFalseIfBothValidatorsReturnFalse() {
        assertFalse(orFreePath.test(new BoardMovement(board, new Movement(board.getPosition(1,'c'), board.getPosition(3,'a')))));
    }
}