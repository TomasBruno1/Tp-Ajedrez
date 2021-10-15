package australchess.pieces;

import australchess.cli.GameManager;
import australchess.movement.BoardMovement;
import australchess.movement.Movement;
import australchess.movement.validators.Castling;
import australchess.movement.validators.SelfCheck;
import australchess.movement.validators.TargetSquare;
import lombok.Setter;

import java.util.List;

public class King extends Piece {
    @Setter
    boolean moved = false;

    Castling castlingValidator = new Castling();

    public King(String color) {
        super(color);
        this.pieceId = 'K';
        this.validators = List.of(new TargetSquare(), new SelfCheck(GameManager.checkDetector));
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = movement.getOffsetY();
        int offsetX = movement.getOffsetX();
        if(offsetX == 0 && offsetY == 0) return false;

        if(offsetY == 0 && Math.abs(offsetX) == 2 && !moved) return true;

        return Math.abs(offsetX) <= 1 && Math.abs(offsetY) <= 1;
    }

    public boolean isCastling(Movement movement) {
        int offsetY = movement.getOffsetY();
        int offsetX = movement.getOffsetX();
        return offsetY == 0 && Math.abs(offsetX) == 2 && !moved;
    }

    public boolean testCastling(BoardMovement boardMovement) {
        return castlingValidator.test(boardMovement);
    }
}
