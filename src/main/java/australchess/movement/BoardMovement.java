package australchess.movement;

import australchess.cli.Board;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardMovement {
    Board board;
    Movement movement;
}
