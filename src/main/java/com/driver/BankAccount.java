package com.driver;

public class BankAccount {
    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        if (digits <= 0 || sum < 0 || sum > digits * 9) {
            throw new Exception("Account Number can not be generated");
        }
        StringBuilder sb = new StringBuilder(digits);
        int remainingSum = sum;
        for (int i = 0; i < digits; i++) {
            int digit = Math.min(remainingSum, 9);
            sb.append(digit);
            remainingSum -= digit;
        }
        if (remainingSum != 0) {
            throw new Exception("Account Number can not be generated");
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }
}