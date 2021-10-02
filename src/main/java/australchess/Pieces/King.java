package australchess.Pieces;

import australchess.cli.BoardPosition;

public class King extends Piece {
    public King(String color) {
        super(color);
        this.pieceId = 'K';
    }

    @Override
    public boolean isLegalMovement(BoardPosition from, BoardPosition to) {
        //TODO implement!
        return false;
    }
}
