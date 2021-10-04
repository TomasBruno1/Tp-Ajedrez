package australchess.cli;

import australchess.pieces.Piece;
import lombok.var;

import java.util.List;
import java.util.Optional;

public abstract class RectangleBoardPrinter implements BoardPrinter {
    String print(List<BoardPosition> positions, List<Character> files, List<Integer> ranks) {
        var builder = new StringBuilder();

        for(var file : files) {
            builder.append(file).append("|");
            for(var rank : ranks) {
                Optional<Piece> piece = findPiece(file, rank, positions);
                if(piece.isPresent()) {
                    if(piece.get().getColor().equals("black")) builder.append("\u001B[31m");
                    builder.append(piece.get().getPieceId());
                    builder.append("\u001B[0m");
                } else builder.append(' ');
                builder.append("|");
            }
            builder.append("\n");
        }
        builder.append("  ");
        ranks.forEach(r -> builder.append(r).append(" "));
        builder.append("\n");
        return builder.toString();
    }

    private static Optional<Piece> findPiece(Character file, Integer rank, List<BoardPosition> positions) {
        return positions.stream().filter(p -> p.getLetter() == file && p.getNumber().equals(rank)).findFirst().map(BoardPosition::getPiece);
    }
}
