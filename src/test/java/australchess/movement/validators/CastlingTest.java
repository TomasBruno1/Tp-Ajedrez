package australchess.movement.validators;

import australchess.cli.Board;
import australchess.factories.BoardFactory;
import australchess.factories.DefaultBoardFactory;
import australchess.factories.DefaultPieceSetFactory;
import australchess.factories.PieceSetFactory;
import australchess.movement.BoardMovement;
import australchess.movement.Movement;
import australchess.pieces.King;
import australchess.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CastlingTest {
    Castling castling = new Castling();
    BoardFactory boardFactory = new DefaultBoardFactory();
    PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    Board board = boardFactory.createBoard(pieceSetFactory.createPieceSet("white"), pieceSetFactory.createPieceSet("black"));

    @Test
    void Test001_CastlingShouldReturnTrueIfNeitherRookNorKingHasMovedAndPathIsClear() {
        board.getPosition(6,'a').setPiece(null);
        board.getPosition(7,'a').setPiece(null);

        assertTrue(castling.test(new BoardMovement(board, new Movement(board.getPosition(5,'a'), board.getPosition(7,'a')))));
    }

    @Test
    void Test002_CastlingShouldReturnFalseIfThereIsAPieceOnPath() {
        assertFalse(castling.test(new BoardMovement(board, new Movement(board.getPosition(5,'a'), board.getPosition(7,'a')))));
    }

    @Test
    void Test003_CastlingShouldReturnFalseIfRookMoved() {
        board.getPosition(6,'a').setPiece(null);
        board.getPosition(7,'a').setPiece(null);
        ((Rook)(board.getPosition(8,'a').getPiece())).setMoved(true);
        assertFalse(castling.test(new BoardMovement(board, new Movement(board.getPosition(5,'a'), board.getPosition(7,'a')))));
    }
}