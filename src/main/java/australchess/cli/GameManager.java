package australchess.cli;

import australchess.Factories.*;
import lombok.Getter;

public class GameManager {
    final BoardFactory boardFactory = new DefaultBoardFactory();
    final PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    @Getter final Board board;
    final Player[] players = new Player[2];
    int currentPlayerIndex = 0;

    public GameManager(String whitePlayer, String blackPlayer) {
        board = boardFactory.createBoard(pieceSetFactory.createPieceSet("white"), pieceSetFactory.createPieceSet("black"));
        players[0] = new Player("white", whitePlayer);
        players[1] = new Player("black", blackPlayer);
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public static boolean shouldContinue() {
        return true; //TODO Implement!
    }
}
