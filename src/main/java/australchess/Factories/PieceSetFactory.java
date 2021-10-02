package australchess.Factories;

import australchess.Pieces.Piece;

public interface PieceSetFactory {
    Piece[] createPieceSet(String color);
}
