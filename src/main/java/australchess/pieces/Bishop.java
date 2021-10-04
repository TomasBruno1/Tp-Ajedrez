package australchess.pieces;

import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.movement.validators.BishopFreePath;
import australchess.movement.validators.FreePath;
import australchess.movement.validators.SelfCheck;
import australchess.movement.validators.TargetSquare;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
        this.pieceId = 'B';
        this.validators = List.of(new BishopFreePath(), new TargetSquare(), new SelfCheck(GameManager.checkDetector));
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = movement.getOffsetY();
        int offsetX = movement.getOffsetX();
        if(offsetX == 0 & offsetY == 0) return false;
        return (Math.abs(offsetX) == Math.abs(offsetY));
    }
}
