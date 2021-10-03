package australchess.pieces;

import australchess.movement.Movement;

public interface Movable {
    boolean isLegalMovement(Movement movement);
}
