package australchess.pieces;

import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.movement.validators.RookFreePath;
import australchess.movement.validators.SelfCheck;
import australchess.movement.validators.TargetSquare;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Rook extends Piece{
    @Getter @Setter
    private boolean moved = false;

    public Rook(String color) {
        super(color);
        this.pieceId = 'R';
        this.validators = List.of(new RookFreePath(), new TargetSquare(), new SelfCheck(GameManager.checkDetector));
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = movement.getOffsetY();
        int offsetX = movement.getOffsetX();
        return (offsetX == 0 && offsetY != 0) || (offsetX != 0 && offsetY == 0);
    }

    public boolean canCastle(){
        return !moved;
    }
}
