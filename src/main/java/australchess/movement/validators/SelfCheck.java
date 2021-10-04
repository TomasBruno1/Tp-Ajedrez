package australchess.movement.validators;

import australchess.cli.Board;
import australchess.cli.CheckDetector;
import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.pieces.Piece;

public class SelfCheck implements MovementValidator {
    private final CheckDetector checkDetector;

    public SelfCheck(CheckDetector checkDetector) {
        this.checkDetector = checkDetector;
    }

    @Override
    public boolean validate(Board board, Movement movement) {
        Piece pieceToMove = movement.getFrom().getPiece();
        Piece pieceOnTarget = movement.getTo().getPiece();
        if(pieceOnTarget != null && pieceOnTarget.getPieceId().equals('K') && !pieceOnTarget.getColor().equals(pieceToMove.getColor())) return true;
        movement.getFrom().setPiece(null);
        movement.getTo().setPiece(pieceToMove);
        boolean isValid = !checkDetector.isChecked(board, pieceToMove.getColor());
        movement.getFrom().setPiece(pieceToMove);
        movement.getTo().setPiece(pieceOnTarget);
        return isValid;
    }
}
