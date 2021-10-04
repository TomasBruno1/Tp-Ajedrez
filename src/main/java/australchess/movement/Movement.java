package australchess.movement;

import australchess.cli.BoardPosition;
import lombok.Data;

@Data
public class Movement {
    BoardPosition from;
    BoardPosition to;

    public Movement(BoardPosition from, BoardPosition to) {
        this.from = from;
        this.to = to;
    }

    public int getOffsetX() {
        return to.getNumber() - from.getNumber();
    }

    public int getOffsetY() {
        return to.getLetter() - from.getLetter();
    }
}
