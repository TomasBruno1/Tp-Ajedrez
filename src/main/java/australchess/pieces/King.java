package australchess.pieces;

import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.movement.validators.FreePath;
import australchess.movement.validators.SelfCheck;
import australchess.movement.validators.TargetSquare;

import java.util.List;

public class King extends Piece {
    public King(String color) {
        super(color);
        this.pieceId = 'K';
        this.validators = List.of(new SelfCheck(GameManager.checkDetector), new TargetSquare());
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = getOffsetY(movement);
        int offsetX = getOffsetX(movement);
        if(offsetX == 0 && offsetY == 0) return false;
        return Math.abs(offsetX) <= 1 && Math.abs(offsetY) <= 1;
    }
}
