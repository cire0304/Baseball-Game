package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    private static Random random = new Random();

    public static List<Integer> generate(int numberOfRandomNumber) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < numberOfRandomNumber){
            addRandomNumber(randomNumbers);
        }
        return randomNumbers;
    }

    private static void addRandomNumber(List<Integer> randomNumbers) {
        int randomNumber = getRandomNumber();
        if(!randomNumbers.contains(randomNumber)){
            randomNumbers.add(randomNumber);
        }
    }

    private static int getRandomNumber(){
        return random.nextInt(9) + 1;
    }

}
