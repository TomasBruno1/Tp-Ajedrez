package australchess.pieces;

import australchess.cli.Board;
import australchess.movement.Movement;
import australchess.movement.generators.MovementGenerator;
import australchess.movement.validators.MovementValidator;
import lombok.Data;

import java.util.List;

@Data
public abstract class Piece implements Movable {
    String color;
    Character pieceId;
    List<MovementValidator> validators;
    MovementGenerator generator;

    public Piece(String color){
        this.color = color;
    }

    public boolean validateMove(Board board, Movement movement){
        for (MovementValidator validator : validators) {
            if(!validator.validate(board, movement)) return false;
        }
        return true;
    }

    protected int getOffsetX(Movement movement) {
        return movement.getTo().getNumber() - movement.getFrom().getNumber();
    }

    protected int getOffsetY(Movement movement) {
        return movement.getTo().getLetter() - movement.getFrom().getLetter();
    }
}
