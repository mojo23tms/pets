package WordFreauencyCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] textToProcess = sc.nextLine().replaceAll("[^a-zA-Z'\\d* ]", "").toLowerCase().split("\\s+");

        if (textToProcess.length != 0) {
            Map<String, Integer> wordsCount = new HashMap<String, Integer>();


            for (String word : textToProcess) {
                if (!wordsCount.keySet().contains(word)) {
                    wordsCount.put(word, 1);
                } else {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }
            }
            System.out.println(wordsCount);
        }
    }
}
