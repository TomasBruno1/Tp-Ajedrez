package australchess.movement.validators;

import australchess.cli.Board;
import australchess.cli.CheckDetector;
import australchess.movement.Movement;

public class SelfCheck implements MovementValidator {
    private CheckDetector checkDetector;

    public SelfCheck(CheckDetector checkDetector) {
        this.checkDetector = checkDetector;
    }

    @Override
    public boolean validate(Board board, Movement movement) {
        return true; //TODO implement!
    }
}
