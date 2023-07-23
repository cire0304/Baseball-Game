import java.util.*;

public class UserInputReader {

    private Scanner scanner = new Scanner(System.in);
    private final int gameBallOfNum = 3;

    public List<Integer> getInput() {
        while (true) {
            try {
                int userInput = scanner.nextInt();
                return getInputAsList(userInput);
            } catch (InputMismatchException  e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("입력을 받는 도중 문제가 발생했습니다.");
                scanner.nextLine();
            }
        }
    }

    private List<Integer> getInputAsList(int userInput) {
        List<Integer> list = convertToList(userInput);
        checkValidFormat(list);
        return list;
    }

    private void checkValidFormat(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        if (list.size() != gameBallOfNum) {
            throw new NumberFormatException(gameBallOfNum + "자리 숫자를 입력해주세요. (값의 범위 1 ~ 9)");
        }
        if (set.size() != gameBallOfNum) {
            throw new NumberFormatException("서로 다른 숫자 " + gameBallOfNum + "자리를 입력해주세요");
        }
        if (list.contains(0)) {
            throw new NumberFormatException("입력 숫자의 범위는 1 ~ 9 입니다.");
        }
    }

    private List<Integer> convertToList(int input) {
        List<Integer> list = new ArrayList<>();
        while (input > 0) {
            list.add(input % 10);
            input /= 10;
        }
        Collections.reverse(list);
        return list;
    }

}
