package com.mojo23tms.spending.cli;

import com.mojo23tms.spending.model.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Expense> exp = new ArrayList<>();
        System.out.println("Welcome to Spending Tracker!\nLet's help you keep more and waste less!");
        Scanner sc = new Scanner(System.in);
        while(true) {
            printMenuWithChoice();
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    Expense newExp = new Expense();
                    exp.add(newExp);
                    System.out.println("Expense is added!\n");
                    continue;
                case 2:
                    if(exp.isEmpty()) {
                        System.out.println("No expenses added yet!\n");
                        continue;
                    }
                    for (Expense expense : exp) {
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
