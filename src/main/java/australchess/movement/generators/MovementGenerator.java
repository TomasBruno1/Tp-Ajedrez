package australchess.movement.generators;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.movement.Movement;

import java.util.List;

public interface MovementGenerator {
    List<Movement> generate(Board board, BoardPosition from);
}
