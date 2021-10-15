package australchess.movement.validators;

import australchess.cli.Board;
import australchess.movement.BoardMovement;
import australchess.movement.Movement;

import java.util.function.Predicate;

public interface MovementValidator extends Predicate<BoardMovement> {
    boolean test(BoardMovement boardMovement);
}
