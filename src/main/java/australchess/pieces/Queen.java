package australchess.pieces;

import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.movement.validators.*;

import java.util.List;

public class Queen extends Piece{

    public Queen(String color) {
        super(color);
        this.pieceId = 'Q';
        this.validators = List.of(new BishopFreePath(), new RookFreePath(), new SelfCheck(GameManager.checkDetector), new TargetSquare());
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = getOffsetY(movement);
        int offsetX = getOffsetX(movement);
        if(offsetX == 0 && offsetY == 0) return false;
        return Math.abs(offsetX) == Math.abs(offsetY) || offsetX == 0 || offsetY == 0;
    }
}
