package australchess.factories;

import australchess.pieces.Piece;
import australchess.cli.Board;
import australchess.cli.BoardPosition;

import java.util.ArrayList;
import java.util.List;

public class LongBoardFactory implements BoardFactory {
    @Override
    public Board createBoard(Piece[] whitePieces, Piece[] blackPieces) {
        List<BoardPosition> positions = new ArrayList<>(64);

        int i = 0;
        for (char letter = 'a'; letter <= 'b'; letter++) {
            for (int number = 1; number <= 8; number++) {
                positions.add(new BoardPosition(whitePieces[i], number, letter));
                i++;
            }
        }

        i = 0;
        for (char letter = 'l'; letter >= 'k'; letter--) {
            for (int number = 1; number <= 8; number++) {
                positions.add(new BoardPosition(blackPieces[i], number, letter));
                i++;
            }
        }

        for (char letter = 'c'; letter <= 'j'; letter++) {
            for (int number = 1; number <= 8; number++) {
                positions.add(new BoardPosition(null, number, letter));
            }
        }

        return new Board(positions);
    }
}
