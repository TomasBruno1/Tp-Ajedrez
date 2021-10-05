package australchess.movement.generators;

import australchess.cli.Board;
import australchess.cli.BoardPosition;
import australchess.movement.Movement;

import java.util.ArrayList;
import java.util.List;

public class MovementGenerator {

    public List<Movement> generate(Board board, BoardPosition from) {
        List<Movement> result = new ArrayList<>();
        for (BoardPosition position : board.getPositions()) {
            if(position.getPiece() != null && position.getPiece().getPieceId().equals('K')) continue;
            result.add(new Movement(from, position));
        }
        result.removeIf(movement -> !board.validateMovement(movement, from.getPiece().getColor()));
        return result;
    }

}
