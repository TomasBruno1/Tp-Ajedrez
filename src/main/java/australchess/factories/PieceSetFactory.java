package australchess.factories;

import australchess.pieces.Piece;

public interface PieceSetFactory {
    Piece[] createPieceSet(String color);
}
