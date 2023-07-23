import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final int gameBallOfNum = 3;

    private List<Integer> gameResult = new ArrayList<>();

    public void of(int strikeNum, int ballNum, int outNum) {
        gameResult.clear();
        gameResult.add(strikeNum);
        gameResult.add(ballNum);
        gameResult.add(outNum);
    }

    public boolean isGameEnd() {
        if (gameResult.size() != gameBallOfNum) {
            return false;
        }
        return getStrikeNum() == gameBallOfNum;
    }

    public void print(int gameRound) {
        if (getStrikeNum() == gameBallOfNum) {
            printGameEndFormat(gameRound);
            return;
        }
        printGameContinueFormat(gameRound);
    }

    private int getStrikeNum() {
        return gameResult.get(0);
    }

    private int getBallNum() {
        return gameResult.get(1);
    }

    private int getOutNum() {
        return gameResult.get(2);
    }

    private void printGameEndFormat(int gameRound) {
        System.out.println(gameRound + " - " +
                "S:" + getStrikeNum() + ", " +
                "B:" + getBallNum() + ", " +
                "O:" + getOutNum() + " (종료)");
    }

    private void printGameContinueFormat(int gameRound) {
        System.out.println(gameRound + " - " +
                "S:" + getStrikeNum() + ", " +
                "B:" + getBallNum() + ", " +
                "O:" + getOutNum());
    }

}
