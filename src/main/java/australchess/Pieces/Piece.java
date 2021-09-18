package australchess.Pieces;

import lombok.Data;

@Data
public abstract class Piece implements Movable {
    String color;
    String name;
    Character pieceId;
}
