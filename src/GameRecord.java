public class GameRecord implements Comparable<GameRecord>{
    private int gameRound;
    private int answer;
    private long minutes;
    private long seconds;

    public GameRecord(int gameRound, int answer, long minutes, long seconds) {
        this.gameRound = gameRound;
        this.answer = answer;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public int compareTo(GameRecord g) {
        return this.gameRound != g.gameRound ? this.gameRound - g.gameRound : (int) (this.getGameTime() - g.getGameTime());
    }

    public String print(int rank) {
        String stringBuilder = rank + "위 " +
                answer + "/" +
                gameRound + " " +
                minutes + "분 " +
                seconds + "초" + "\n";
        return stringBuilder;
    }

    private long getGameTime() {
        return 60 * minutes + seconds;
    }
}
