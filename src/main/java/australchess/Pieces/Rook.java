package australchess.Pieces;

import australchess.cli.BoardPosition;

public class Rook extends Piece{

    @Override
    public boolean isLegalMovement(BoardPosition from, BoardPosition to) {
        return from.getLetter() == to.getLetter() && !from.getNumber().equals(to.getNumber()) || from.getLetter() != to.getLetter() && from.getNumber().equals(to.getNumber());
    }
}
