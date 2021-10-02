package australchess.Pieces;

import australchess.cli.BoardPosition;

public class Knight extends Piece {
    public Knight(String color) {
        super(color);
        this.pieceId = 'N';
    }

    @Override
    public boolean isLegalMovement(BoardPosition from, BoardPosition to) {
        //TODO implement!
        return false;
    }
}
