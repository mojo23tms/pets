package com.mojo23tms.spending.service;

import com.mojo23tms.spending.model.Expense;
import com.mojo23tms.spending.repository.ExpenseRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ExpenseService {

    private long id = 0;

    private final ExpenseRepository er = new ExpenseRepository();

    public void addExpense(int amount, String category, String description) throws IllegalArgumentException {
        verifyAmount(amount);
        verifyCategory(category);
        verifyDescription(description);
        id++;
        er.saveExpense(new Expense(amount, category, description, id));

    }

    public int getTotalSpent() throws NullPointerException{
        checkIfEmpty();
        int sum = 0;
        for (Expense expense : er.getExpenseList()) {
            sum += expense.getAmount();
        }
        return sum;
    }

    public int getTotalSpent(String category) throws NullPointerException{
        checkIfEmpty();
        int sum = 0;
        for (Expense expense : er.getExpenseList()) {
            if (expense.getCategory().equals(category)) {
                sum += expense.getAmount();
            }
        }
        return sum;
    }

    public List<Expense> getAllExpenses() throws NullPointerException{
        checkIfEmpty();
        return er.getExpenseList();
    }

    public void updateExpenseById(long id, int amount, String category, String description) {
        Expense updated = new Expense(amount, category, description, id);
        if (!er.updateExpense(id, updated)) {
            throw new NoSuchElementException("No expense with such ID");
        }
    }

    public void deleteExpense(long id) {
        if (!er.deleteExpense(id)) {
            throw new NoSuchElementException("Expense with ID: " + id + "doesn't exist");
        }
    }

    void checkIfEmpty() {
        if (getAllExpenses().isEmpty()) {
            throw new NullPointerException("Expense list is empty!");
        }
    }

    void verifyAmount(int amount) {
        if (!(amount > 0)) {
            throw new IllegalArgumentException("Amount should be greater than 0!");
        }
    }

    void verifyCategory(String category) {
        if (category.isBlank()) {
            throw new IllegalArgumentException("Category can't be empty!");
        }
    }

    void verifyDescription(String description) {
        if (description.isBlank()) {
            throw new IllegalArgumentException("Description can't be empty!");
        }
    }


}
