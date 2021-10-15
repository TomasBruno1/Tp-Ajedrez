package australchess.movement.validators;

import australchess.movement.BoardMovement;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class OrFreePath implements MovementValidator {
    final private MovementValidator a;
    final private MovementValidator b;

    @Override
    public boolean test(BoardMovement boardMovement) {
        return a.or(b).test(boardMovement);
    }
}
