package com.mojo23tms.spending.cli;

import com.mojo23tms.spending.model.Expense;
import com.mojo23tms.spending.service.CliService;
import com.mojo23tms.spending.service.ExpenseService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ExpenseService es = new ExpenseService();
        System.out.println("Welcome to Spending Tracker!\nLet's help you keep more and waste less!");
        Scanner sc = new Scanner(System.in);
        CliService cliService = new CliService(es);
        while (true) {
            printMenu();
            int input;
            try {
                input = cliService.readMenuChoice(sc);
            } catch (NumberFormatException e) {
                System.out.printf(e.getMessage());
                continue;
            }
            switch (input) {
                case 1:
                    while (true) {
                        try {
                            int amount = readAmount(sc);
                            String category = readCategory(sc);
                            String description = readDescription(sc);
                            cliService.optionAddExpense(amount, category, description);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    try {
                        cliService.optionShowAllExpense();
                        break;
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println(cliService.optionShowTotalSpent());
                        break;
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        String category = readCategory(sc);
                        System.out.println(cliService.optionShowSpentByCategory(category));
                        break;
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        long id = readId(sc);
                        int amount = readAmount(sc);
                        String category = readCategory(sc);
                        String description = readDescription(sc);
                        System.out.println(cliService.optionUpdateExpense(id, amount, category, description));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        long id = readId(sc);
                        System.out.println(cliService.optionDeleteExpense(id));
                        break;
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using our Spending Tracker!");
                    break;
            }
            break;
        }
    }

    private static void printMenu() {
        System.out.print("\n1. Add expense\n" +
                "2. Show all expenses\n" +
                "3. Show total spent\n" +
                "4. Show total by category\n" +
                "5. Update expense\n" +
                "6. Delete expense\n" +
                "0. Exit\n" +
                "Your choice: ");
    }

    private static int readAmount(Scanner sc) {
        System.out.print("Specify amount (USD): ");
        String amount = sc.nextLine();
        return Integer.parseInt(amount);
    }

    private static String readCategory(Scanner sc) {
        System.out.print("Specify category: ");
        return sc.nextLine();
    }

    private static String readDescription(Scanner sc) {
        System.out.print("Specify description: ");
        return sc.nextLine();
    }

    private static long readId(Scanner sc) {
        System.out.print("Specify ID: ");
        String id = sc.nextLine();
        return Long.parseLong(id);
    }

}
