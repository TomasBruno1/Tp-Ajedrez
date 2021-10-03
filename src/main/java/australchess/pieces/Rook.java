package australchess.pieces;

import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.movement.validators.FreePath;
import australchess.movement.validators.RookFreePath;
import australchess.movement.validators.SelfCheck;
import australchess.movement.validators.TargetSquare;

import java.util.List;

public class Rook extends Piece{

    public Rook(String color) {
        super(color);
        this.pieceId = 'R';
        this.validators = List.of(new RookFreePath(), new SelfCheck(GameManager.checkDetector), new TargetSquare());
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = getOffsetY(movement);
        int offsetX = getOffsetX(movement);
        return (offsetX == 0 && offsetY != 0) || (offsetX != 0 && offsetY == 0);
    }
}
