package australchess.movement.validators;

import australchess.cli.Board;
import australchess.movement.BoardMovement;
import australchess.movement.Movement;

public class PawnFreePath implements MovementValidator {

    @Override
    public boolean test(BoardMovement boardMovement) {
        Movement movement = boardMovement.getMovement();
        Board board = boardMovement.getBoard();

        int dirY = movement.getTo().getLetter() > movement.getFrom().getLetter() ? 1 : -1;
        if(Math.abs(movement.getFrom().getLetter() - movement.getTo().getLetter()) == 2) {
            return board.getPosition(movement.getFrom().getNumber(), (char) (movement.getFrom().getLetter() + dirY)).getPiece() == null;
        }

        return true;
    }
}
