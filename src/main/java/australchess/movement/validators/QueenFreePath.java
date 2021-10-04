package australchess.movement.validators;

import australchess.cli.Board;
import australchess.movement.Movement;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QueenFreePath implements FreePath{
    final private BishopFreePath bishopFreePath;
    final private RookFreePath rookFreePath;

    @Override
    public boolean validate(Board board, Movement movement) {
        int offsetX = movement.getTo().getNumber() - movement.getFrom().getNumber();
        int offsetY = movement.getTo().getLetter() - movement.getFrom().getLetter();

        if(offsetX == 0 || offsetY == 0) {
            return rookFreePath.validate(board, movement);
        } else return bishopFreePath.validate(board, movement);
    }
}
