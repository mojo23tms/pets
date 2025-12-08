package com.mojo23tms.spending.cli;

import com.mojo23tms.spending.model.Expense;
import com.mojo23tms.spending.service.ExpenseService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ExpenseService es = new ExpenseService();
        System.out.println("Welcome to Spending Tracker!\nLet's help you keep more and waste less!");
        Scanner sc = new Scanner(System.in);
        while(true) {
            printMenuWithChoice();
            String input = sc.nextLine();
            switch (Integer.parseInt(input)) {
                case 1:
                    System.out.print("Add expense amount (USD): ");
                    String amount = sc.nextLine();
                    System.out.print("Specify category: ");
                    String category = sc.nextLine();
                    System.out.print("Add description: ");
                    String description = sc.nextLine();
                    es.addExpense(Integer.parseInt(amount), category, description);
                    System.out.println("Expense is added!\n");
                    continue;
                case 2:
                    var allExpense = es.getAllExpenses();
                    if(allExpense.isEmpty()) {
                        System.out.println("No expenses added yet!\n");
                        continue;
                    }
                    for (Expense expense : allExpense) {
                        System.out.println(expense);
                    }
                    continue;
                case 0:
                    System.out.println("Thank you for using our Spending Tracker!");
                    break;
            }
            break;
        }
    }

    private static void printMenuWithChoice() {
        System.out.print("1. Add expense\n2. Show all expenses\n0. Exit\nYour choice: ");
    }

}
