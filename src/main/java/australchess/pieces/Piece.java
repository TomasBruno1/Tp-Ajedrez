package australchess.pieces;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.movement.BoardMovement;
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
        this.generator = new MovementGenerator();
    }

    public boolean validateMove(Board board, Movement movement){
        for (MovementValidator validator : validators) {
            if(!validator.test(new BoardMovement(board, movement))) return false;
        }
        return true;
    }

    public boolean canMove(Board board, BoardPosition piecePosition) {
        return !generator.generate(board, piecePosition).isEmpty();
    }
}
