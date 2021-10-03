package australchess.movement.validators;

import australchess.cli.Board;
import australchess.movement.Movement;

public interface MovementValidator {
    boolean validate(Board board, Movement movement);
}
