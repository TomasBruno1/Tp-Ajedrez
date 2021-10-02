package australchess.Pieces;

import australchess.cli.BoardPosition;

public class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
        this.pieceId = 'B';
    }

    @Override
    public boolean isLegalMovement(BoardPosition from, BoardPosition to) {
        //TODO implement!
        return false;
    }
}
