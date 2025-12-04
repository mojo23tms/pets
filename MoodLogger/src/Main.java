package MoodLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MoodEntry> entries = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to the Mood Logger v1.0\n");
        while(true) {
            System.out.print("\n1. Add mood\n2. Summary\n3. Exit\n4. Show all mood entries\n");
            System.out.print("Specify preferred option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("- Enter your mood rating (1-5): ");
                    int rating;
                    while (true) {
                        try {
                            rating = Integer.parseInt(sc.next());
                            if (rating > 5 || rating < 1) {
                                System.out.print("Wrong value! Try again: ");
                                continue;
                            }
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.print("Sorry, wrong input! Try again: ");
                        }
                    }
                    System.out.print("- Enter note on your mood (optional): ");
                    String note = sc.nextLine();
                    entries.add(new MoodEntry(rating, note));
                    System.out.print("\nNew entry added! Choose next:\n");
                    continue;
                case 2:
                    printSummary(entries);
                    continue;
                case 3:
                    break;
                case 4:
                    for (MoodEntry entry : entries) {
                        entry.printEntry();
                    }
                    continue;
            }
            break;
        }
    }

    private static void printSummary(List<MoodEntry> entries) {
        if (entries.isEmpty()) {
            System.out.println("No entries to summarize yet.");
            return;
        }
        float sum = 0f;
        int max = 1;
        int min = 5;
        for (MoodEntry entry : entries) {
            int rating = entry.getRating();
            sum += rating;
            if (max < rating) {
                max = rating;
            } else if (min > rating) {
                min = rating;
            }
        }

        System.out.printf(
                "Mood summary:\n- Entries: %d\n- Average mood: %.2f\n- Best mood: %d\n- Worst mood: %d\n",
                entries.size(), sum / entries.size(), max, min);
    }
}
