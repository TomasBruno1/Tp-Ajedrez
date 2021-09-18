package australchess.Factories;

import australchess.cli.Board;
import australchess.cli.BoardPosition;

import java.util.List;

public class LongBoardFactory implements BoardFactory {
    @Override
    public Board createBoard() {
        List<BoardPosition> positions = List.of(
                new BoardPosition('R', 1, 'a'),
                new BoardPosition('N', 2, 'a'),
                new BoardPosition('B', 3, 'a'),
                new BoardPosition('K', 4, 'a'),
                new BoardPosition('Q', 5, 'a'),
                new BoardPosition('B', 6, 'a'),
                new BoardPosition('N', 7, 'a'),
                new BoardPosition('R', 8, 'a'),

                new BoardPosition('P', 1, 'b'),
                new BoardPosition('P', 2, 'b'),
                new BoardPosition('P', 3, 'b'),
                new BoardPosition('P', 4, 'b'),
                new BoardPosition('P', 5, 'b'),
                new BoardPosition('P', 6, 'b'),
                new BoardPosition('P', 7, 'b'),
                new BoardPosition('P', 8, 'b'),

                new BoardPosition(null, 1, 'c'),
                new BoardPosition(null, 2, 'c'),
                new BoardPosition(null, 3, 'c'),
                new BoardPosition(null, 4, 'c'),
                new BoardPosition(null, 5, 'c'),
                new BoardPosition(null, 6, 'c'),
                new BoardPosition(null, 7, 'c'),
                new BoardPosition(null, 8, 'c'),

                new BoardPosition(null, 1, 'd'),
                new BoardPosition(null, 2, 'd'),
                new BoardPosition(null, 3, 'd'),
                new BoardPosition(null, 4, 'd'),
                new BoardPosition(null, 5, 'd'),
                new BoardPosition(null, 6, 'd'),
                new BoardPosition(null, 7, 'd'),
                new BoardPosition(null, 8, 'd'),

                new BoardPosition(null, 1, 'e'),
                new BoardPosition(null, 2, 'e'),
                new BoardPosition(null, 3, 'e'),
                new BoardPosition(null, 4, 'e'),
                new BoardPosition(null, 5, 'e'),
                new BoardPosition(null, 6, 'e'),
                new BoardPosition(null, 7, 'e'),
                new BoardPosition(null, 8, 'e'),

                new BoardPosition(null, 1, 'f'),
                new BoardPosition(null, 2, 'f'),
                new BoardPosition(null, 3, 'f'),
                new BoardPosition(null, 4, 'f'),
                new BoardPosition(null, 5, 'f'),
                new BoardPosition(null, 6, 'f'),
                new BoardPosition(null, 7, 'f'),
                new BoardPosition(null, 8, 'f'),

                new BoardPosition(null, 1, 'g'),
                new BoardPosition(null, 2, 'g'),
                new BoardPosition(null, 3, 'g'),
                new BoardPosition(null, 4, 'g'),
                new BoardPosition(null, 5, 'g'),
                new BoardPosition(null, 6, 'g'),
                new BoardPosition(null, 7, 'g'),
                new BoardPosition(null, 8, 'g'),

                new BoardPosition(null, 1, 'h'),
                new BoardPosition(null, 2, 'h'),
                new BoardPosition(null, 3, 'h'),
                new BoardPosition(null, 4, 'h'),
                new BoardPosition(null, 5, 'h'),
                new BoardPosition(null, 6, 'h'),
                new BoardPosition(null, 7, 'h'),
                new BoardPosition(null, 8, 'h'),

                new BoardPosition(null, 1, 'i'),
                new BoardPosition(null, 2, 'i'),
                new BoardPosition(null, 3, 'i'),
                new BoardPosition(null, 4, 'i'),
                new BoardPosition(null, 5, 'i'),
                new BoardPosition(null, 6, 'i'),
                new BoardPosition(null, 7, 'i'),
                new BoardPosition(null, 8, 'i'),

                new BoardPosition(null, 1, 'j'),
                new BoardPosition(null, 2, 'j'),
                new BoardPosition(null, 3, 'j'),
                new BoardPosition(null, 4, 'j'),
                new BoardPosition(null, 5, 'j'),
                new BoardPosition(null, 6, 'j'),
                new BoardPosition(null, 7, 'j'),
                new BoardPosition(null, 8, 'j'),

                new BoardPosition('P', 1, 'k'),
                new BoardPosition('P', 2, 'k'),
                new BoardPosition('P', 3, 'k'),
                new BoardPosition('P', 4, 'k'),
                new BoardPosition('P', 5, 'k'),
                new BoardPosition('P', 6, 'k'),
                new BoardPosition('P', 7, 'k'),
                new BoardPosition('P', 8, 'k'),

                new BoardPosition('R', 1, 'l'),
                new BoardPosition('N', 2, 'l'),
                new BoardPosition('B', 3, 'l'),
                new BoardPosition('K', 4, 'l'),
                new BoardPosition('Q', 5, 'l'),
                new BoardPosition('B', 6, 'l'),
                new BoardPosition('N', 7, 'l'),
                new BoardPosition('R', 8, 'l')
        );
        return new Board(positions);
    }
}
