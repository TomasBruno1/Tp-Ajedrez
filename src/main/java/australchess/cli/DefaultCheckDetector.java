package australchess.cli;

import australchess.movement.Movement;

import java.util.List;

public class DefaultCheckDetector implements CheckDetector {
    @Override
    public boolean isChecked(Board board, String color) {
        BoardPosition kingPosition = board.getKingPosition(color);

        List<BoardPosition> oppositePiecePositions;

        if(color.equals("white")) oppositePiecePositions = board.getPiecePositions("black");
        else oppositePiecePositions = board.getPiecePositions("white");

        for (BoardPosition oppositePiecePosition : oppositePiecePositions) {
            if(board.validateMovement(new Movement(oppositePiecePosition, kingPosition), oppositePiecePosition.getPiece().getColor())) return true;
        }

        return false;
    }
}
