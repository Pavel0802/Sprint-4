package ru.yandex.practicum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class AccountNegativeTest {

    Account account;
    private String accountName;

    public AccountNegativeTest(Account account, String accountName) {
        this.account = account;
        this.accountName = accountName;
    }

    @Parameterized.Parameters(name = "{index}:Пользователь с именем {1} не может быть создан")
    public static Object[][] getAccountName() {
        return new Object[][]{
                {Account.createName(), Account.getName() + RandomStringUtils.randomAlphabetic(20 - Account.getName().length())},
                {Account.createName(), Account.getName().substring(0, 2)},
                {Account.createName(), ""},
                {Account.createName(), null},
                {Account.createName(), Account.getName().substring(0, Account.getName().indexOf(" ") + 2) + " " + Account.getName().substring(Account.getName().indexOf(" ") + 1, Account.getName().length())},
                {Account.createName(), " " + Account.getName()},
                {Account.createName(), Account.getName() + " "},
        };
    }

    @Test
    public void AccountNegativeTest() {
        account = new Account(accountName);
        assertFalse("The name must be shorter than 19 characters", account.checkNameToEmboss());
    }


}
