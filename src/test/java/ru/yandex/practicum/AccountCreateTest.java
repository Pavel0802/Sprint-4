package ru.yandex.practicum;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class AccountCreateTest {
    private String accountName;
    Account account;

    @Test
    public void createAccountTest() {
        account = Account.createName();
        assertFalse(account.getName().isEmpty());
    }
}
