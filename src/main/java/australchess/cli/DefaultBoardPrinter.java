package australchess.cli;

import lombok.var;

import java.util.List;

// Improve or create a new implementation if you like, this is a naive implementation
public class DefaultBoardPrinter extends RectangleBoardPrinter {
    @Override
    public String print(List<BoardPosition> positions) {
        var files = List.of('h', 'g', 'f', 'e', 'd', 'c', 'b', 'a');
        var ranks = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        return print(positions, files, ranks);
    }
}
