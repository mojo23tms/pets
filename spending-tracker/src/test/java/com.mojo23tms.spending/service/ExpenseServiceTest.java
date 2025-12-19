package com.mojo23tms.spending.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mojo23tms.spending.service.ExpenseService;
import com.mojo23tms.spending.model.Expense;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ExpenseServiceTest {
    private ExpenseService es;

    @BeforeEach
    public void setup() {
        es = new ExpenseService();
    }

    @Test
    public void checkValidExpense() {
        int amount = 25;
        String category = "food";
        String description = "lunch";
        es.addExpense(amount, category, description);
        List<Expense> expenseList = es.getAllExpenses();
        assertThat(expenseList)
                .as("Expense list isn't valid!")
                .hasSize(1);
        assertThat(expenseList.get(0))
                .satisfies(expense -> {
                    assertThat(expense.getAmount())
                            .as("Amount of added expense is wrong!")
                            .isEqualTo(amount);
                    assertThat(expense.getCategory())
                            .as("Category of added expense is wrong!")
                            .isEqualTo(category);
                    assertThat(expense.getDescription())
                            .as("Description of added expense is wrong!")
                            .isEqualTo(description);
                });

    }

    @Test
    public void checkThrowsException() {
        int amount = -25;
        String category = "food";
        String description = "lunch";
        assertThatThrownBy(() ->
                es.addExpense(amount, category, description)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("greater than 0");
    }
}
