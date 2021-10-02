package australchess.cli;

import australchess.Pieces.Piece;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public @Data class BoardPosition {
    private final @Getter Piece piece;
    private final @Getter Integer number;
    private final @Getter Character letter;
}
