package com.driver;
public class Main {
    public static void main(String[] args) {

        // Create a BankAccount object
        BankAccount account1 = new BankAccount("John Doe", 10000.0, 5000.0);
        System.out.println("Account Holder Name: " + account1.getName());
        System.out.println("Account Number: " + account1.generateAccountNumber(10, 50));
        System.out.println("Account Balance: " + account1.getBalance());
        account1.deposit(5000.0);
        System.out.println("Account Balance after deposit: " + account1.getBalance());
        try {
            account1.withdraw(12000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Account Balance after withdrawal: " + account1.getBalance());

        // Create a CurrentAccount object
        CurrentAccount account2 = new CurrentAccount("Jane Smith", 10000.0, "TRADELIC");
        System.out.println("Account Holder Name: " + account2.getName());
        System.out.println("Account Number: " + account2.generateAccountNumber(10, 50));
        System.out.println("Account Balance: " + account2.getBalance());
        System.out.println("Trade License ID: " + account2.getTradeLicenseId());
        account2.validateLicenseId();
        System.out.println("Validated Trade License ID: " + account2.getTradeLicenseId());

        // Create a SavingsAccount object
        SavingsAccount account3 = new SavingsAccount("Bob Johnson", 10000.0, 0.05, 5000.0);
        System.out.println("Account Holder Name: " + account3.getName());
        System.out.println("Account Number: " + account3.generateAccountNumber(10, 50));
        System.out.println("Account Balance: " + account3.getBalance());
        System.out.println("Interest Rate: " + account3.getRate());
        System.out.println("Maximum Withdraw Limit: " + account3.getMaximumWithdrawLimit());
        account3.withdraw(3000.0);
        System.out.println("Account Balance after withdrawal: " + account3.getBalance());
        try {
            account3.withdraw(9000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Account Balance after withdrawal: " + account3.getBalance());
        System.out.println("Simple Interest after 3 years: " + account3.getSimpleInterest(3));
        System.out.println("Compound Interest after 3 years with quarterly interest: " + account3.getCompoundInterest(4, 3));

        // Create a StudentAccount object
        StudentAccount account4 = new StudentAccount("Mary Lee", 5000.0, "XYZ University");
        System.out.println("Account Holder Name: " + account4.getName());
        System.out.println("Account Number: " + account4.generateAccountNumber(10, 50));
        System.out.println("Account Balance: " + account4.getBalance());
        System.out.println("Institution Name: " + account4.getInstitutionName());
    }
}
}