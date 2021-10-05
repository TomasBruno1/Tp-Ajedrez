package australchess.cli;

import com.github.lalyos.jfiglet.FigletFont;
import lombok.var;

import java.io.IOException;
import java.util.Scanner;

public class App {

    final static BoardPrinter boardPrinter = new DefaultBoardPrinter();
    static GameManager gameManager;

    public static void main(String[] args) throws IOException {

        printHeader();
        final var whitePlayerName = askForString("Name of player that moves white: ");
        final var blackPlayerName = askForString("Name of player that moves black: ");
        System.out.println();
        System.out.println();

        gameManager = new GameManager(whitePlayerName, blackPlayerName);

        while(gameManager.shouldContinue()) {
            printCurrentPlayerTurn();
            System.out.println();
            printBoard();
            final var positionFrom = askForPosition("Enter position of the piece you want to move");
            final var positionTo = askForPosition("Enter position of cell you want to move it to");
            gameManager.move(positionFrom, positionTo);

            System.out.println();
            System.out.println();
        }

        System.out.println("The game is over!");
        printBoard();
    }

    private static void printBoard() {
        var board = gameManager.getBoard();
        var boardAsString = App.boardPrinter.print(board.getPositions());
        System.out.println(boardAsString);
    }

    private static Player playerToMove() {
        return gameManager.getCurrentPlayer();
    }

    private static ParsedPosition askForPosition(String question) {
        System.out.println(question);
        System.out.print("Enter in format -> (number,letter): ");
        var scanner = new Scanner(System.in);
        var positionAsString = scanner.nextLine();
        return ParsedPositionParser.parse(positionAsString)
                .orElseGet(() -> askForPosition("The position " + positionAsString + " is invalid. Please enter a new one"));
    }

    private static void printCurrentPlayerTurn() {
        System.out.println("It's " + playerToMove().getName() + " turn!");
    }

    private static String askForString(String question) {
        System.out.println(question);
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void printHeader() throws IOException {
        String header = FigletFont.convertOneLine("AustralChess");
        System.out.println(header);
    }
}
