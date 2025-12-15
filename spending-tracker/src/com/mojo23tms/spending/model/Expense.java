package com.mojo23tms.spending.model;

import java.time.LocalDate;
import java.util.Scanner;

public class Expense {

    private final int amount;
    private final String category;
    private final String description;
    private final LocalDate dateTime;

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public int getAmount() {
        return this.amount;
    }

    public Expense(int amount, String category, String description, LocalDate dateTime) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "- Date: " + this.dateTime + "\n" +
                "- Amount spent: $" + this.amount + "\n" +
                "- Category of expense: " + this.category + "\n" +
                "- Description: " + this.description + "\n" +
                "==========";

    }
}
