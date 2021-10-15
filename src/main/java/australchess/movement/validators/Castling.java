package australchess.movement.validators;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.movement.BoardMovement;
import australchess.movement.Movement;
import australchess.pieces.Rook;

public class Castling implements MovementValidator {
    StraightFreePath straightFreePath = new StraightFreePath();

    @Override
    public boolean test(BoardMovement boardMovement) {
        Movement movement = boardMovement.getMovement();
        Board board = boardMovement.getBoard();

        int dirX = movement.getTo().getNumber() > movement.getFrom().getNumber() ? 1 : -1;
        BoardPosition rookPosition = board.findCastlingRookPosition(movement, dirX);
        if (rookPosition == null) return false;
        Rook rook = (Rook) rookPosition.getPiece();
        if(!rook.canCastle()) return false;
        return straightFreePath.test(new BoardMovement(board, new Movement(movement.getFrom(), rookPosition)));
    }
}
