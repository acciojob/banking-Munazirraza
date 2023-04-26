package com.driver;

public class CurrentAccount extends BankAccount {
    private String tradeLicenseId;

    public CurrentAccount(String name, double balance, String tradeLicenseId) {
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();
    }

    public void validateLicenseId() {
        boolean isValid = true;
        char[] chars = tradeLicenseId.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    char temp = chars[i];
                    chars[i] = chars[i - 1];
                    chars[i - 1] = temp;
                    if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                        i++;
                    }
                }
            }
            tradeLicenseId = new String(chars);
            if (!isValidTradeLicenseId(tradeLicenseId)) {
                throw new RuntimeException("Valid License can not be generated");
            }
        }
    }

    private boolean isValidTradeLicenseId(String tradeLicenseId) {
        for (char c : tradeLicenseId.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
