package australchess.cli;

import australchess.movement.Movement;
import australchess.pieces.*;
import lombok.Data;

import java.util.ArrayList;
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
        if(pieceToMove.getClass() == King.class && ((King) pieceToMove).isCastling(movement)) {
            castle(movement);
            return;
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

    // podria ser otro validator para el rey con un OR.
    private void castle(Movement movement) {
        int dirX = movement.getTo().getNumber() > movement.getFrom().getNumber() ? 1 : -1;
        BoardPosition rookPosition = getPosition(movement.getTo().getNumber() + dirX, movement.getTo().getLetter());
        if(rookPosition == null || rookPosition.getPiece() == null || rookPosition.getPiece().getClass() != Rook.class) throw new RuntimeException("That movement is not valid.");
        Rook rook = (Rook) rookPosition.getPiece();
        if(!rook.canCastle()) throw new RuntimeException("That movement is not valid.");
        if(!validateCastlingPath(movement, dirX)) throw new RuntimeException("That movement is not valid.");
        movement.getTo().setPiece(movement.getFrom().getPiece());
        movement.getFrom().setPiece(null);
        rookPosition.setPiece(null);
        getPosition(movement.getTo().getNumber() - dirX, movement.getTo().getLetter()).setPiece(rook);
    }

    private boolean validateCastlingPath(Movement movement, int dirX) {
        int offsetX = Math.abs(movement.getOffsetX());
        for (int i = 1; i <= offsetX; i++) {
            if(getPosition(movement.getFrom().getNumber() + dirX*i, movement.getFrom().getLetter()).getPiece() != null) return false;
        }
        return true;
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
