package australchess.cli;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    List<BoardPosition> positions;

    public Board(List<BoardPosition> positions){
        this.positions = positions;
    }
}
