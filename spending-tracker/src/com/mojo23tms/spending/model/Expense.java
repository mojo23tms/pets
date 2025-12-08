package com.mojo23tms.spending.model;

import java.time.LocalDate;
import java.util.Scanner;

public class Expense {

    private final int amount;
    private final String category;
    private final String description;
    private final LocalDate dateTime;

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
