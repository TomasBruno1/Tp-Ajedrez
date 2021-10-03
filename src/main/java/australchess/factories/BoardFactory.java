package australchess.factories;

import australchess.pieces.Piece;
import australchess.cli.Board;

public interface BoardFactory {
    Board createBoard(Piece[] whitePieces, Piece[] blackPieces);
}
