package australchess.cli;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public @Data class BoardPosition {
    private final @Getter Character pieceId; //TODO migrate type to Piece
    private final @Getter Integer number;
    private final @Getter Character letter;
}
