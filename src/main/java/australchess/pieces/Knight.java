package australchess.pieces;

import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.movement.validators.FreePath;
import australchess.movement.validators.SelfCheck;
import australchess.movement.validators.TargetSquare;

import java.util.List;

public class Knight extends Piece {
    public Knight(String color) {
        super(color);
        this.pieceId = 'N';
        this.validators = List.of(new SelfCheck(GameManager.checkDetector), new TargetSquare());
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = getOffsetY(movement);
        int offsetX = getOffsetX(movement);
        return Math.abs(offsetX * offsetY) == 2;
    }
}
