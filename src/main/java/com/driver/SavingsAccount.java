package com.driver;

public class SavingsAccount extends BankAccount {
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double rate, double maxWithdrawalLimit) {
        super(name, balance, 0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if (balance - amount < minimumBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

    public double getSimpleInterest(int years) {
        BigDecimal bd1 = new BigDecimal(Double.toString(balance));
        BigDecimal bd2 = new BigDecimal(Double.toString(rate));
        BigDecimal bd3 = new BigDecimal(Integer.toString(years));
        return bd1.multiply(bd2).multiply(bd3).doubleValue();
    }

    public double getCompoundInterest(int times, int years) {
        BigDecimal bd1 = new BigDecimal(Double.toString(balance));
        BigDecimal bd2 = new BigDecimal(Double.toString(rate/times+1));
        BigDecimal bd3 = new BigDecimal(Integer.toString(times*years));
        return bd1.multiply(bd2.pow(times*years)).doubleValue();
    }
}