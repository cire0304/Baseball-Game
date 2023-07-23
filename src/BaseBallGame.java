import util.RandomNumberGenerator;

import java.util.List;

public class BaseBallGame {
    private GameRecordManager recordManager;
    private GameResult gameResult;
    private List<Integer> gameAnswer;
    private final int gameBallOfNum = 3;
    private int gameRound = 0;

    public BaseBallGame() {
        this.recordManager = new GameRecordManager();
        this.gameResult = new GameResult();
    }

    public void start() {
        gameAnswer = RandomNumberGenerator.generate(gameBallOfNum);
        gameRound = 0;
        recordManager.recordStart();
    }

    public void end() {
        recordManager.save(gameRound, gameAnswer);
    }

    public void tryGame(List<Integer> balls) {
        gameRound++;

        int strikeCount = countStrike(balls);
        int ballCount = countBall(balls);
        int outCount = countOut(strikeCount, ballCount);
        gameResult.of(strikeCount, ballCount, outCount);
    }

    public boolean isGameEnd() {
        return gameResult.isGameEnd();
    }

    public void printResult() {
        gameResult.print(gameRound);
    }

    private int countStrike(List<Integer> balls) {
        int strikeNumber = 0;
        for (int i = 0; i < balls.size(); i++) {
            strikeNumber += incrementIfStrike(balls, i);
        }
        return strikeNumber;
    }

    private int countBall(List<Integer> balls) {
        int ballNumber = 0;
        for (int i = 0; i < balls.size(); i++) {
            ballNumber += incrementOneIfBall(balls, i);
        }
        return ballNumber;
    }

    private int countOut(int strikeNum, int ballNum) {
        return gameAnswer.size() - strikeNum - ballNum;
    }

    private int incrementIfStrike(List<Integer> balls, int ballOrder) {
        int targetBall = balls.get(ballOrder);
        if (gameAnswer.get(ballOrder) == targetBall) {
            return 1;
        }
        return 0;
    }

    private int incrementOneIfBall(List<Integer> balls, int ballOrder) {
        int targetBall = balls.get(ballOrder);
        for (int i = 0; i < gameAnswer.size(); i++) {
            if (ballOrder == i) continue;
            if (gameAnswer.get(i) == targetBall) {
                return 1;
            }
        }
        return 0;
    }

}
