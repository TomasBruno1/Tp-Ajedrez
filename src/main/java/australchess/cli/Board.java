package australchess.cli;

import australchess.movement.BoardMovement;
import australchess.movement.Movement;
import australchess.pieces.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if(pieceToMove.getClass() == King.class && ((King) pieceToMove).isCastling(movement)) {
            if(((King) pieceToMove).testCastling(new BoardMovement(this, movement))) {
                int dirX = movement.getTo().getNumber() > movement.getFrom().getNumber() ? 1 : -1;
                BoardPosition rookPosition = findCastlingRookPosition(movement, dirX);

                movement.getTo().setPiece(movement.getFrom().getPiece());
                movement.getFrom().setPiece(null);
                getPosition(movement.getTo().getNumber() - dirX, movement.getTo().getLetter()).setPiece(rookPosition.getPiece());
                rookPosition.setPiece(null);
                return;
            }
            throw new RuntimeException("That movement is not valid");
        }
        movement.getFrom().setPiece(null);
        movement.getTo().setPiece(pieceToMove);
        if(pieceToMove.getClass() == Pawn.class) {
            Pawn pawn = (Pawn) pieceToMove;
            pawn.setMoved(true);
            if(pawn.isAtEnd(this, movement.getTo())) {
                movement.getTo().setPiece(new Queen(color));
            }
        }
        if(pieceToMove.getClass() == Rook.class) ((Rook) pieceToMove).setMoved(true);
        if(pieceToMove.getClass() == King.class) ((King) pieceToMove).setMoved(true);
    }

    public BoardPosition findCastlingRookPosition(Movement movement, int dirX) {
        Character letter = movement.getFrom().getLetter();
        List<BoardPosition> rookPositions = getPiecePositions(movement.getFrom().getPiece().getColor()).stream().filter(e -> e.getPiece().getPieceId() == 'R' && e.getLetter() == letter).collect(Collectors.toList());
        if(dirX > 0) rookPositions = rookPositions.stream().filter(e -> e.getNumber() > movement.getFrom().getNumber()).collect(Collectors.toList());
        else rookPositions = rookPositions.stream().filter(e -> e.getNumber() < movement.getFrom().getNumber()).collect(Collectors.toList());
        if(rookPositions.isEmpty()) return null;
        return rookPositions.get(0);
    }

    public BoardPosition getPosition(Integer number, Character letter){
        for (BoardPosition position : positions) {
            if(position.getNumber().equals(number) && position.getLetter().equals(letter)) return position;
        }
        return null;
    }

    public BoardPosition getKingPosition(String color) {
        for (BoardPosition position : positions) {
            if(position.getPiece() != null) {
                if(position.getPiece().getPieceId().equals('K') && position.getPiece().getColor().equals(color)) return position;
            }
        }
        throw new RuntimeException(String.format("There is no %s king on the board.", color));
    }

    public List<BoardPosition> getPiecePositions(String color) {
        List<BoardPosition> result = new ArrayList<>(16);
        for (BoardPosition position : positions) {
            if(position.getPiece() != null) {
                if(position.getPiece().getColor().equals(color)) result.add(position);
            }
        }
        return result;
    }

    public boolean validateMovement(Movement movement, String color) {
        Piece pieceToMove = movement.getFrom().getPiece();
        if(pieceToMove == null) return false;
        if(!pieceToMove.getColor().equals(color)) return false;
        if(!pieceToMove.isLegalMovement(movement)) return false;
        return pieceToMove.validateMove(this, movement);
    }
}
