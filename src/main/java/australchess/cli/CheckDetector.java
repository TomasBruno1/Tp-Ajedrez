package australchess.cli;

public interface CheckDetector {
    boolean isChecked(Board board, String color);
}
