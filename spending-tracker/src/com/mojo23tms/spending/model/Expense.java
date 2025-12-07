package com.mojo23tms.spending.model;

import java.util.Scanner;

public class Expense {

    private int amount;
    private String category;
    private String description;

    public Expense() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add expense amount (USD): ");
        setAmount(sc.nextInt());
        sc.nextLine();
        System.out.print("Specify category: ");
        setCategory(sc.nextLine());
        System.out.print("Add description: ");
        setDescription(sc.nextLine());
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Expense is added: \n" +
                "- Amount spent: $" + this.amount + "\n" +
                "- Category of expense: " + this.category + "\n" +
                "- Description: " + this.description + "\n";

    }
}
