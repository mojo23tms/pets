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

    public void addExpense(int amount, String category, String description) {
        boolean validAmount = amount > 0;
        boolean validCategory = !category.isBlank();
        boolean validDescription = !description.isBlank();

        if (!validAmount) {
            throw new IllegalArgumentException("Amount should be greater than 0!");
        } else if (!validCategory) {
            throw new IllegalArgumentException("Category can't be empty!");
        } else if (!validDescription) {
            throw new IllegalArgumentException("Description can't be empty!");
        }
        id++;
        er.saveExpense(new Expense(amount, category, description, id));
    }

    public int getTotalSpent() {
        int sum = 0;
        for(Expense expense : er.getExpenseList()) {
            sum += expense.getAmount();
        }
        return sum;
    }

    public int getTotalSpent(String category) {
        int sum = 0;
        for(Expense expense : er.getExpenseList()) {
            if (expense.getCategory().equals(category)) {
                sum += expense.getAmount();
            }
        }
        return sum;
    }

    public List<Expense> getAllExpenses() {
        return er.getExpenseList();
    }

    public boolean updateExpenseById(long id, int amount, String category, String description) {
        if (amount > 0) {
        }

        if (amount > 0 && !category.isBlank() && !description.isBlank()) {
            Expense updated = new Expense(amount, category, description, id);
            return er.updateExpense(id, updated);
        }
        return false;
    }

    public boolean deleteExpense(long id) {
        if (er.deleteExpense(id)) {
            throw new NoSuchElementException("Expense with ID: " + id + "doesn't exist");
        }

        return true;

    }


}
