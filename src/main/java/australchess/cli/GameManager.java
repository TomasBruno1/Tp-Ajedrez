package australchess.cli;

import australchess.factories.*;
import australchess.movement.Movement;
import lombok.Getter;

import java.util.List;

public class GameManager {
    final BoardFactory boardFactory = new DefaultBoardFactory();
    final PieceSetFactory pieceSetFactory = new DefaultPieceSetFactory();
    @Getter final Board board;
    final Player[] players = new Player[2];
    int currentPlayerIndex = 0;

    public static CheckDetector checkDetector = new DefaultCheckDetector();

    public GameManager(String whitePlayer, String blackPlayer) {
        board = boardFactory.createBoard(pieceSetFactory.createPieceSet("white"), pieceSetFactory.createPieceSet("black"));
        players[0] = new Player("white", whitePlayer);
        players[1] = new Player("black", blackPlayer);
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public boolean shouldContinue() {
        if(checkDetector.isChecked(board, getCurrentPlayer().getColor())){
            boolean isCheckmated = true;
            List<BoardPosition> piecePositions = board.getPiecePositions(getCurrentPlayer().getColor());
            for (BoardPosition piecePosition : piecePositions) {
                if(piecePosition.getPiece().canMove(board, piecePosition)){
                    isCheckmated = false;
                    break;
                }
            }
            if(isCheckmated) {
                System.out.printf("%s is checkmated!%n", getCurrentPlayer().getName());
                return false;
            }
            System.out.printf("%s is checked%n", getCurrentPlayer().getName());
        }
        return true; //TODO Implement!
    }

    public void move(ParsedPosition from, ParsedPosition to) {
        Movement movement;

        try {
            movement = new Movement(from.toBoardPosition(board), to.toBoardPosition(board));
            board.move(movement, getCurrentPlayer().getColor());
            nextPlayer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void nextPlayer() {
        currentPlayerIndex ++;
        if(currentPlayerIndex == players.length) currentPlayerIndex = 0;
    }
}
