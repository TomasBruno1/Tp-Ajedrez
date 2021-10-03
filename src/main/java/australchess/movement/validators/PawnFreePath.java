package australchess.movement.validators;

import australchess.cli.Board;
import australchess.movement.Movement;

public class PawnFreePath implements FreePath {
    @Override
    public boolean validate(Board board, Movement movement) {

        int dirY = movement.getTo().getLetter() > movement.getFrom().getLetter() ? 1 : -1;
        if(Math.abs(movement.getFrom().getLetter() - movement.getTo().getLetter()) == 2) {
            return board.getPosition(movement.getFrom().getNumber(), (char) (movement.getFrom().getLetter() + dirY)).getPiece() == null;
        }

        return true;
    }
}
