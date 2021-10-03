package australchess.movement.validators;

import australchess.cli.Board;
import australchess.movement.Movement;

public class BishopFreePath implements FreePath{
    @Override
    public boolean validate(Board board, Movement movement) {
        int srcX = movement.getFrom().getNumber();
        int srcY = movement.getFrom().getLetter();
        int destX = movement.getTo().getNumber();
        int destY = movement.getTo().getLetter();

        int dirX = destX>srcX ? 1 : -1;
        int dirY = destY>srcY ? 1 : -1;

        for (int i=1;i<Math.abs(destX-srcX);++i) {
            if (board.getPosition(srcX+i*dirX, (char) (srcY+i*dirY)).getPiece() != null) return false;
        }
        return true;
    }
}
