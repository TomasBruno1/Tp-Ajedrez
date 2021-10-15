package australchess.cli;

import australchess.movement.BoardMovement;

public interface CheckmateDetector {
    boolean isCheckmated(Board board, String color);
}
