package australchess.Pieces;

import australchess.cli.BoardPosition;

public interface Movable {
    boolean isLegalMovement(BoardPosition from, BoardPosition to);
}
