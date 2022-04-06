package ru.yandex.practicum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AccountPositiveTest {

    Account account;
    private String accountName;

    public AccountPositiveTest(Account account, String accountName) {
        this.account = account;
        this.accountName = accountName;
    }

    @Parameterized.Parameters(name = "{index}:A user named {1} has been created")
    public static Object[][] getAccountName() {
        return new Object[][]{
                {Account.createName(), Account.getName().substring(0, 3)},
                {Account.createName(), Account.getName() + RandomStringUtils.randomAlphabetic(19 - Account.getName().length())}
        };
    }

    @Test
    public void AccountPositiveTest() {
        account = new Account(accountName);
        assertTrue("This is a valid name", account.checkNameToEmboss());
    }

}
