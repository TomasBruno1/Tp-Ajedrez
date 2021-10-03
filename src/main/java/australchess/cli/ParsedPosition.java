package australchess.cli;

import lombok.Data;
import lombok.Getter;

public @Data class ParsedPosition {
    private final @Getter Integer number;
    private final @Getter Character letter;

    public BoardPosition toBoardPosition(Board board) {
        for (BoardPosition position : board.getPositions()) {
            if(position.getLetter().equals(this.getLetter()) && position.getNumber().equals(this.getNumber()))
                return position;
        }
        throw new RuntimeException("This position is not on the board");
    }
}
