package australchess.pieces;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.cli.GameManager;
import australchess.movement.Movement;
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
        this.validators = List.of(new PawnFreePath(), new TargetSquare(), new SelfCheck(GameManager.checkDetector));
    }

    @Override
    public boolean isLegalMovement(Movement movement) {
        int offsetY = movement.getOffsetY();
        int offsetX = movement.getOffsetX();
        if(color.equals("white")){
            if(movement.getTo().getPiece() != null) return Math.abs(offsetX) == 1 && offsetY == 1;
            return (offsetX == 0 && offsetY == 1) || (!moved && offsetX == 0 && offsetY == 2);
        } else {
            if(movement.getTo().getPiece() != null) return Math.abs(offsetX) == 1 && offsetY == -1;
            return (offsetX == 0 && offsetY == -1) || (!moved && offsetX == 0 && offsetY == -2);
        }
    }

    public boolean isAtEnd(Board board, BoardPosition position) {
        if(color.equals("white")){
            return board.getPosition(position.getNumber(), (char) (position.getLetter() + 1)) == null;
        } else {
            return board.getPosition(position.getNumber(), (char) (position.getLetter() - 1)) == null;
        }
    }
}
