import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameRecordManager {

    GameRecordWriter recordWriter = new GameRecordWriter();
    private long gameStartTime = 0;
    private long gameEndTime = 0;

    public void recordStart() {
        gameStartTime = System.currentTimeMillis();
    }

    public void save(int gameRound, List<Integer> gameAnswer) {
        GameRecord gameRecord = makeGameRecord(gameRound, gameAnswer);
        recordWriter.save(gameRecord);
    }

    private GameRecord makeGameRecord(int gameRound, List<Integer> balls) {
        int gameAnswer = ListToInt(balls);

        long gamePlayTime = getGamePlayTime();
        Duration duration = Duration.ofMillis(gamePlayTime);
        long minutes = duration.getSeconds() / 60;
        long seconds = duration.minusMinutes(minutes).getSeconds();

        GameRecord gameRecord = new GameRecord(gameRound, gameAnswer, minutes, seconds);
        return gameRecord;
    }

    private long getGamePlayTime() {
        gameEndTime = System.currentTimeMillis();
        return gameEndTime - gameStartTime;
    }

    private int ListToInt(List<Integer> balls) {
        return Integer.parseInt(balls.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("")));
    }
}
