package com.mojo23tms.spending.repository;

import com.mojo23tms.spending.model.Expense;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ExpenseRepository {
    private final List<Expense> expenseList = new ArrayList<>();

    public void saveExpense(Expense exp) {
        expenseList.add(exp);
    }

    public List<Expense> getExpenseList() {
        return List.copyOf(expenseList);
    }

    public Optional<Expense> findById(long id) {
        return getExpenseList().stream()
                .filter(expense -> expense.getId() == id)
                .findAny();
    }

    public boolean deleteById(long id) {
        Optional<Expense> toDelete = findById(id);
        if (toDelete.isEmpty()) {
            return false;
        }
        expenseList.remove(toDelete.get());
        return true;
    }

    public boolean updateById(long id, Map<String, String> data) {
        Optional<Expense> originalExpense = findById(id);

        if (originalExpense.isEmpty()) {
            return false;
        }

        int amount = originalExpense.get().getAmount();
        String category = originalExpense.get().getCategory();
        String description = originalExpense.get().getDescription();

        if (data.containsKey("amount")) {
            amount = Integer.parseInt(data.get("amount"));
        }

        if (data.containsKey("category")) {
            category = data.get("category");
        }

        if (data.containsKey("description")) {
            description = data.get("category");
        }

        Expense updatedExpense = new Expense(amount, category, description, LocalDate.now(), originalExpense.get().getId());
        expenseList.remove(originalExpense.get());
        expenseList.add(updatedExpense);
        return true;
    }

}
