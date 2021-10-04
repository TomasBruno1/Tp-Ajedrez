package australchess.pieces;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.cli.GameManager;
import australchess.movement.Movement;
import australchess.movement.validators.*;

import java.util.List;

public class Queen extends Piece{

    public Queen(String color) {
        super(color);
        this.pieceId = 'Q';
        this.validators = List.of(new QueenFreePath(new BishopFreePath(), new RookFreePath()), new TargetSquare(), new SelfCheck(GameManager.checkDetector));
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = movement.getOffsetY();
        int offsetX = movement.getOffsetX();
        if(offsetX == 0 && offsetY == 0) return false;
        return Math.abs(offsetX) == Math.abs(offsetY) || offsetX == 0 || offsetY == 0;
    }
}
