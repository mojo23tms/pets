package com.mojo23tms.spending.service;

import com.mojo23tms.spending.model.Expense;
import com.mojo23tms.spending.repository.ExpenseRepository;

import java.time.LocalDate;
import java.util.List;

public class ExpenseService {

    private final ExpenseRepository er = new ExpenseRepository();

    public void addExpense(int amount, String category, String description) {
        er.saveExpense(new Expense(amount, category, description, LocalDate.now()));
    }

    public List<Expense> getAllExpenses() {
        return er.getExpenseList();
    }
}
