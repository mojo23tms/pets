package com.mojo23tms.spending.service;

import com.mojo23tms.spending.model.Expense;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CliService {

    ExpenseService es;

    public CliService(ExpenseService es) {
        this.es = es;
    }

    public int readMenuChoice(Scanner sc) {
        String choice = sc.nextLine();
        try {
            return Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong choice! Choose from 0 to 6!");
        }
    }

    public void optionAddExpense(int amount, String category, String description) {
        try {
            es.addExpense(amount, category, description);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nEnter details again!");
        }
    }

    public void optionShowAllExpense() {
        checkIfEmpty();
        for (Expense expense : es.getAllExpenses()) {
            System.out.println(expense);
        }
    }

    public String optionShowTotalSpent() {
        checkIfEmpty();
        return "Total amount spent: $" + es.getTotalSpent();
    }

    public String optionShowSpentByCategory(String category) {
        checkIfEmpty();
        return "Total amount by category \"" + category + "\": $" + es.getTotalSpent(category) + "\n";
    }

    public String optionUpdateExpense(long id, int amount, String category, String description) {
        try {
            verifyAmount(amount);
            verifyCategory(category);
            verifyDescription(description);
            es.updateExpenseById(id, amount, category, description);
            return "Expense updated!";
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String optionDeleteExpense(long id) {
        try {
            es.deleteExpense(id);
            return "Expense removed!";
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private void checkIfEmpty() {
        if (es.getAllExpenses().isEmpty()) {
            throw new NullPointerException("Expense list is empty!");
        }
    }

    private void verifyAmount(int amount) {
        if (!(amount > 0)) {
            throw new IllegalArgumentException("Amount should be greater than 0!");
        }
    }

    private void verifyCategory(String category) {
        if (category.isBlank()) {
            throw new IllegalArgumentException("Category can't be empty!");
        }
    }

    private void verifyDescription(String description) {
        if (description.isBlank()) {
            throw new IllegalArgumentException("Description can't be empty!");
        }
    }
}
