package MoodLogger;

import java.time.LocalDateTime;

public class MoodEntry {
    private final int rating;
    private final String note;
    private LocalDateTime timeStamp;

    public MoodEntry(int rating, String note) {
        this.rating = rating;
        this.note = note;
        timeStamp = LocalDateTime.now();
    }

    protected String getNote() {
        return this.note;
    }

    protected int getRating() {
        return this.rating;
    }

    protected void printEntry() {
        System.out.printf("[%s] rating: %d, note: %s\n", timeStamp, rating, note);
    }
}
