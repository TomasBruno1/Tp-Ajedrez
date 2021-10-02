package australchess.Pieces;

import australchess.cli.BoardPosition;

public class Queen extends Piece{

    public Queen(String color) {
        super(color);
        this.pieceId = 'Q';
    }

    @Override
    public boolean isLegalMovement(BoardPosition from, BoardPosition to) {
        //TODO implement!
        return false;
    }
}
