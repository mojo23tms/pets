package com.mojo23tms.spending.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mojo23tms.spending.service.ExpenseService;
import com.mojo23tms.spending.model.Expense;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ExpenseServiceTest {
    private ExpenseService es;

    private int amount = 25;
    private String category = "food";
    private String description = "lunch";

    @BeforeEach
    public void setup() {
        es = new ExpenseService();
        es.addExpense(amount, category, description);
    }

    @Test
    public void test_addValidExpense() {
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
    public void test_invalidParameterThrowsException() {
        int invalidAmount = -25;
        assertThatThrownBy(() ->
                es.addExpense(invalidAmount, category, description)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("greater than 0");
    }

    @Test
    public void test_validUpdateExpense() {
        long expenseId = es.getAllExpenses().get(0).getId();

        int updAmount = 45;
        String updCategory = "clothes";
        String updDescription = "pants";

        es.updateExpenseById(expenseId, updAmount, updCategory, updDescription);
        assertThat(es.getAllExpenses().get(0))
                .satisfies(expense -> {
                    assertThat(expense.getId())
                            .as("Amount of added expense is wrong!")
                            .isEqualTo(expenseId);
                    assertThat(expense.getAmount())
                            .as("Amount of added expense is wrong!")
                            .isEqualTo(updAmount);
                    assertThat(expense.getCategory())
                            .as("Category of added expense is wrong!")
                            .isEqualTo(updCategory);
                    assertThat(expense.getDescription())
                            .as("Description of added expense is wrong!")
                            .isEqualTo(updDescription);
                });
    }

    @Test
    public void test_validDeleteExpense() {
        long expenseId = es.getAllExpenses().get(0).getId();

        es.addExpense(45, "a", "b");

        es.deleteExpense(expenseId);
        Expense lastExpense = es.getAllExpenses().get(0);
        assertThat(es.getAllExpenses().size())
                .as("Expense wasn't deleted!")
                .isEqualTo(1);
        assertThat(lastExpense.getId())
                .as("Remaining expense ID is changed!")
                .isEqualTo(2);
    }
}
