package australchess.cli;

import java.util.List;

public class DefaultCheckmateDetector implements CheckmateDetector {
    @Override
    public boolean isCheckmated(Board board, String color) {
        List<BoardPosition> piecePositions = board.getPiecePositions(color);
        for (BoardPosition piecePosition : piecePositions) {
            if(piecePosition.getPiece().canMove(board, piecePosition)){
                return false;
            }
        }
        return true;
    }
}
