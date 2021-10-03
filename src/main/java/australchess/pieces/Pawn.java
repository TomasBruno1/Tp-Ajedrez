package australchess.pieces;

import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.movement.validators.FreePath;
import australchess.movement.validators.PawnFreePath;
import australchess.movement.validators.SelfCheck;
import australchess.movement.validators.TargetSquare;
import lombok.Setter;

import java.util.List;

public class Pawn extends Piece{
    @Setter
    boolean moved = false;

    public Pawn(String color) {
        super(color);
        this.pieceId = 'P';
        this.validators = List.of(new PawnFreePath(), new SelfCheck(GameManager.checkDetector), new TargetSquare());
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = getOffsetY(movement);
        int offsetX = getOffsetX(movement);
        if(color.equals("white")){
            if(movement.getTo().getPiece() != null) return Math.abs(offsetX) == 1 && offsetY == 1;
            return (offsetX == 0 && offsetY == 1) || (!moved && offsetX == 0 && offsetY == 2);
        } else {
            if(movement.getTo().getPiece() != null) return Math.abs(offsetX) == 1 && offsetY == -1;
            return (offsetX == 0 && offsetY == -1) || (!moved && offsetX == 0 && offsetY == -2);
        }
    }

}
