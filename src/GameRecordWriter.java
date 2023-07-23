import java.io.*;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameRecordWriter {

    private final String RECODE_FORMAT = "(\\d+)위 (\\d+)\\/(\\d+) (\\d+)분 (\\d+)초";
    private final int GAME_ANSWER_INDEX = 2;
    private final int GAME_ROUND_INDEX = 3;
    private final int MINUTES_INDEX = 4;
    private final int SECONDS_INDEX = 5;
    private final String SAVE_PATH = "./Game Ranking";

    public void save(GameRecord gameRecord) {
        try {
            File gameRankFile = new File(SAVE_PATH);

            if (!gameRankFile.exists()) {
                gameRankFile.createNewFile();
            }

            PriorityQueue<GameRecord> gameRecordHistory = readRecordHistory(gameRankFile);
            gameRecordHistory.add(gameRecord);
            writeGameRecordHistory(gameRankFile, gameRecordHistory);

        } catch (IOException e) {
            System.out.println("게임 기록 저장에 실패했습니다.");
        }

    }

    private PriorityQueue<GameRecord> readRecordHistory(File file) throws IOException {
        String gameHistory = readRecordHistoryAsString(file);
        return convertToQueue(gameHistory);
    }

    private void writeGameRecordHistory(File gameRankFile, PriorityQueue<GameRecord> gameRecordHistory) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(gameRankFile));
        int gameRank = 1;
        while (!gameRecordHistory.isEmpty()) {
            GameRecord gameRecord = gameRecordHistory.poll();
            writer.write(gameRecord.print(gameRank++));
        }
        writer.close();
    }

    private String readRecordHistoryAsString(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }

    private PriorityQueue<GameRecord> convertToQueue(String gameHistory) {
        GameRecord gameRecord;
        Pattern pattern = Pattern.compile(RECODE_FORMAT);
        Matcher matcher = pattern.matcher(gameHistory);

        PriorityQueue<GameRecord> gameRecords = new PriorityQueue<>();
        while (matcher.find()) {
            int gameAnswer = Integer.parseInt(matcher.group(GAME_ANSWER_INDEX));
            int gameRound = Integer.parseInt(matcher.group(GAME_ROUND_INDEX));
            int minutes = Integer.parseInt(matcher.group(MINUTES_INDEX));
            int seconds = Integer.parseInt(matcher.group(SECONDS_INDEX));
            gameRecord = new GameRecord(gameRound, gameAnswer, minutes, seconds);
            gameRecords.add(gameRecord);
        }
        return gameRecords;
    }
}
