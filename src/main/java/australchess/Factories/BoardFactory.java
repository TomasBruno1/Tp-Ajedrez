package australchess.Factories;

import australchess.Pieces.Piece;
import australchess.cli.Board;

import java.util.List;

public interface BoardFactory {
    Board createBoard(Piece[] whitePieces, Piece[] blackPieces);
}
