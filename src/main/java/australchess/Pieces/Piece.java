package australchess.Pieces;

import lombok.Data;

@Data
public abstract class Piece implements Movable {
    String color;
    Character pieceId;

    public Piece(String color){
        this.color = color;
    }
}
