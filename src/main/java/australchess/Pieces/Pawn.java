package australchess.Pieces;

import australchess.cli.BoardPosition;

public class Pawn extends Piece{


    public Pawn(String color) {
        super(color);
        this.pieceId = 'P';
    }

    @Override
    public boolean isLegalMovement(BoardPosition from, BoardPosition to) {
        //TODO implement!
        return false;
    }
}
