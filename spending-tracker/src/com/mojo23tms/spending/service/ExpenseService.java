package com.mojo23tms.spending.service;

import com.mojo23tms.spending.model.Expense;
import com.mojo23tms.spending.repository.ExpenseRepository;

import java.time.LocalDate;
import java.util.List;

public class ExpenseService {

    private final ExpenseRepository er = new ExpenseRepository();

    public void addExpense(int amount, String category, String description) {
        boolean validAmount = amount >= 0;
        boolean validCategory = !category.isEmpty();
        boolean validDescription = !description.isEmpty();

        if (!validAmount) {
            System.out.println("Amount should be greater than 0!");
        } else if (!validCategory) {
            System.out.println("Category can't be empty!");
        } else if (!validDescription) {
            System.out.println("Description can't be empty!");
        }

        if (validAmount && validCategory && validDescription) {
            er.saveExpense(new Expense(amount, category, description, LocalDate.now()));
        }
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
}
