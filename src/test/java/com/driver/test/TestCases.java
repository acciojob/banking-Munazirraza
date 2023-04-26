package com.driver.test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import com.driver.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TestCases {

    @Test
    public void testBankAccount() {
        BankAccount account = new BankAccount("John Doe", 1000, 500);
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.0);
        account.withdraw(1000);
        assertEquals(500, account.getBalance(), 0.0);

        try {
            account.withdraw(400);
            fail("Expected an Insufficient Balance exception to be thrown");
        } catch (Exception e) {
            assertEquals("Insufficient Balance", e.getMessage());
        }

        try {
            BankAccount.generateAccountNumber(4, 10);
            fail("Expected an Account Number can not be generated exception to be thrown");
        } catch (Exception e) {
            assertEquals("Account Number can not be generated", e.getMessage());
        }
    }

    @Test
    public void testCurrentAccount() {
        CurrentAccount account = new CurrentAccount("Jane Smith", 7000, "ABC123");
        assertEquals(7000, account.getBalance(), 0.0);

        try {
            CurrentAccount account2 = new CurrentAccount("Bob Johnson", 4000, "AAB123");
            fail("Expected a Valid License can not be generated exception to be thrown");
        } catch (Exception e) {
            assertEquals("Valid License can not be generated", e.getMessage());
        }

        account.validateLicenseId();
        assertFalse(account.getTradeLicenseId().equals("ABC123"));
    }

    @Test
    public void testSavingsAccount() {
        SavingsAccount account = new SavingsAccount("Alice Lee", 5000, 5.0, 1000);
        account.withdraw(500);
        assertEquals(4500, account.getBalance(), 0.0);

        try {
            account.withdraw(2000);
            fail("Expected a Maximum Withdraw Limit Exceed exception to be thrown");
        } catch (Exception e) {
            assertEquals("Maximum Withdraw Limit Exceed", e.getMessage());
        }

        try {
            account.withdraw(5000);
            fail("Expected an Insufficient Balance exception to be thrown");
        } catch (Exception e) {
            assertEquals("Insufficient Balance", e.getMessage());
        }

        assertEquals(5250, account.getSimpleInterest(5), 0.0);
        assertEquals(5513.16, account.getCompoundInterest(12, 5), 0.01);
    }

    @Test
    public void testStudentAccount() {
        StudentAccount account = new StudentAccount("David Brown", 200, "XYZ College");
        account.deposit(100);
        assertEquals(300, account.getBalance(), 0.0);
    }
}