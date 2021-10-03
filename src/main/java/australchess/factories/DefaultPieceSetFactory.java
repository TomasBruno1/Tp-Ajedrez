package australchess.factories;

import australchess.pieces.*;

public class DefaultPieceSetFactory implements PieceSetFactory {
    @Override
    public Piece[] createPieceSet(String color) {
        Piece[] pieces = new Piece[16];
        for (int i = 0; i < pieces.length; i++) {
            if (7 < i) pieces[i] = new Pawn(color);
            if (i == 0 || i == 7) pieces[i] = new Rook(color);
            if (i == 1 || i == 6) pieces[i] = new Knight(color);
            if (i == 2 || i == 5) pieces[i] = new Bishop(color);
            if (i == 3) pieces[i] = new Queen(color);
            if (i == 4) pieces[i] = new King(color);
        }
        return pieces;
    }
}
