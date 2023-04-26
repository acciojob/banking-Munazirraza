package com.driver;
public class StudentAccount extends BankAccount {
    private String institutionName;

    public StudentAccount(String name, double balance, String institutionName) {
        super(name, balance, 0);
        this.institutionName = institutionName;
    }

    public void withdraw(double amount) throws Exception {
        if (balance - amount < minimumBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }
}