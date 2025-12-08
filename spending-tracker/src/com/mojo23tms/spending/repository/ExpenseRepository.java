package com.mojo23tms.spending.repository;

import com.mojo23tms.spending.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {
    private final List<Expense> expenseList = new ArrayList<>();

    public void saveExpense(Expense exp) {
        expenseList.add(exp);
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

}
