package com.mojo23tms.spending.cli;

import com.mojo23tms.spending.model.Expense;
import com.mojo23tms.spending.repository.ExpenseRepository;
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
            var allExpense = es.getAllExpenses();
            String input = sc.nextLine();
            switch (Integer.parseInt(input)) {
                case 1:
                    int amount = readAmount(sc);
                    String category = readCategory(sc);
                    String description = readDescription(sc);
                    es.addExpense(amount, category, description);
                    System.out.println("Expense is added!\n");
                    continue;
                case 2:
                    if(allExpense.isEmpty()) {
                        System.out.println("No expenses added yet!\n");
                        continue;
                    }
                    for (Expense expense : allExpense) {
                        System.out.println(expense);
                    }
                    continue;
                case 3:
                    if(allExpense.isEmpty()) {
                        System.out.println("No expenses added yet!\n");
                        continue;
                    }
                    System.out.println("Total amount spent: $" + es.getTotalSpent() + "\n");
                    continue;
                case 4:
                    if(allExpense.isEmpty()) {
                        System.out.println("No expenses added yet!\n");
                        continue;
                    }
                    System.out.print("Specify category: ");
                    String categoryToCount = sc.nextLine();
                    System.out.println("Total amount by category \"" + categoryToCount + "\": $" + es.getTotalSpent(categoryToCount) + "\n");
                    continue;
                case 0:
                    System.out.println("Thank you for using our Spending Tracker!");
                    break;
            }
            break;
        }
    }

    private static int readAmount(Scanner sc) {
        System.out.print("Add expense amount (USD): ");
        String amount = sc.nextLine();
        return Integer.parseInt(amount);
    }

    private static String readCategory(Scanner sc) {
        System.out.print("Specify category: ");
        return sc.nextLine();
    }

    private static String readDescription(Scanner sc) {
        System.out.print("Add description: ");
        return sc.nextLine();
    }

    private static void printMenuWithChoice() {
        System.out.print("" +
                "1. Add expense\n" +
                "2. Show all expenses\n" +
                "3. Show total spent\n" +
                "4. Show total by category\n" +
                "0. Exit\n" +
                "Your choice: ");
    }

}
