package com.mojo23tms.spending.model;

public class MoneyBox {

    int moneyStored = 0;

    public MoneyBox(int startMoney) {
        this.moneyStored += startMoney;
    }

    public void addMoney(int amount) {
        this.moneyStored += amount;
        System.out.printf("Added $%d to the account, total amount stored: $%d", amount, moneyStored);
    }

}
