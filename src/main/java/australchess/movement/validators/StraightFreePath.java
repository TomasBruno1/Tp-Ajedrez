package australchess.movement.validators;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.movement.BoardMovement;
import australchess.movement.Movement;

public class StraightFreePath implements MovementValidator {

    @Override
    public boolean test(BoardMovement boardMovement) {
        Movement movement = boardMovement.getMovement();
        Board board = boardMovement.getBoard();

        if(movement.getOffsetX() != 0 && movement.getOffsetY() != 0) return false;

        BoardPosition from = movement.getFrom();
        BoardPosition to = movement.getTo();
        int maxNumber = from.getNumber() > to.getNumber() ? from.getNumber() : to.getNumber();
        int minNumber = from.getNumber() > to.getNumber() ? to.getNumber() : from.getNumber();
        int maxLetter = from.getLetter() > to.getLetter() ? from.getLetter() : to.getLetter();
        int minLetter = from.getLetter() > to.getLetter() ? to.getLetter() : from.getLetter();

        if(from.getLetter().equals(to.getLetter())) {
            for (int i = minNumber + 1; i < maxNumber; i++) {
                if(board.getPosition(i, to.getLetter()).getPiece() != null) return false;
            }
        } else {
            for (int i = minLetter + 1; i < maxLetter; i++) {
                if(board.getPosition(from.getNumber(), (char) i).getPiece() != null) return false;
            }
        }
        return true;
    }
}
