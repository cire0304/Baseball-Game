import java.util.List;

public class Problem {

    public static void main(String[] args) {
        UserInputReader inputReader = new UserInputReader();
        BaseBallGame baseBallGame = new BaseBallGame();

        baseBallGame.start();
        while (!baseBallGame.isGameEnd()) {
            List<Integer> balls = inputReader.getInput();
            baseBallGame.tryGame(balls);
            baseBallGame.printResult();
        }
        baseBallGame.end();
        baseBallGame.printResult();
    }
}

