package australchess.cli;

import australchess.pieces.Piece;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public @Data class BoardPosition {
    private Piece piece;
    private final Integer number;
    private final Character letter;

    public BoardPosition(Piece piece, Integer number, Character letter) {
        this.piece = piece;
        this.number = number;
        this.letter = letter;
    }
}
