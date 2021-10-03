package australchess.movement.validators;

import australchess.cli.Board;
import australchess.movement.Movement;
import australchess.pieces.Piece;

public class TargetSquare implements MovementValidator {
    @Override
    public boolean validate(Board board, Movement movement) {
        Piece movingPiece = movement.getFrom().getPiece();
        Piece pieceOnTarget = movement.getTo().getPiece();
        if(pieceOnTarget == null) return true;
        return !pieceOnTarget.getColor().equals(movingPiece.getColor());
    }
}
