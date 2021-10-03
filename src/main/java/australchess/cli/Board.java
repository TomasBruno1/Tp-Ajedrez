package australchess.cli;

import australchess.movement.Movement;
import australchess.pieces.Pawn;
import australchess.pieces.Piece;
import lombok.Data;

import java.util.List;

@Data
public class Board {
    List<BoardPosition> positions;

    public Board(List<BoardPosition> positions){
        this.positions = positions;
    }

    public void move(Movement movement, String color) {
        Piece pieceToMove = movement.getFrom().getPiece();
        if(pieceToMove == null) throw new RuntimeException("There is no piece on the chosen position.");
        if(!pieceToMove.getColor().equals(color)) throw new RuntimeException("That piece is not of your color.");
        if(!pieceToMove.isLegalMovement(movement)) throw new RuntimeException("That piece does not move like that.");
        if(!pieceToMove.validateMove(this, movement)) throw new RuntimeException("That movement is not valid!");
        movement.getFrom().setPiece(null);
        movement.getTo().setPiece(pieceToMove);
        if(pieceToMove.getClass() == Pawn.class) ((Pawn) pieceToMove).setMoved(true);
    }

    public BoardPosition getPosition(Integer number, Character letter){
        for (BoardPosition position : positions) {
            if(position.getNumber().equals(number) && position.getLetter().equals(letter)) return position;
        }
        return null;
    }
}
