package australchess.movement.validators;

import australchess.cli.Board;
import australchess.movement.Movement;

import java.util.function.Predicate;
// ver predicate
public interface MovementValidator {
    boolean validate(Board board, Movement movement);
}
