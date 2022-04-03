package ru.yandex.practicum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class AccountTest {

    private String accountName;
    Account account;

    @Before
    public void setUp() {
        account = Account.createName();
        accountName = account.getName();
    }

    @Test
    @DisplayName("Проверка ошибки при несоответствии количества символов")
    @Description("Тест проверяет возврат ошибки в случае длины полного имени пользователя более 19 символов")
    public void checkNameMoreLightTest() {
        String newAccountName = accountName + RandomStringUtils.randomAlphabetic(20 - accountName.length());
        account = new Account(newAccountName);
        assertFalse(account.checkNameToEmboss());
        System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки при несоответствии количества символов")
    @Description("Тест проверяет возврат ошибки в случае длины полного имени пользователя менее 3 символов")
    public void checkNameBelowThreeCharTest() {
        String newAccountName = accountName.substring(0, 2);
        account = new Account(newAccountName);
        assertFalse(account.checkNameToEmboss());
        System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки наличия пробелов")
    @Description("Тест проверяет возврат ошибки в случае наличия более одного пробела")
    public void checkNameTwoSpaceTest() {
        int spacePosition = accountName.indexOf(" ");
        String newAccountName = accountName.substring(0, spacePosition + 2) + " " + accountName.substring(spacePosition + 1, accountName.length());
        account = new Account(newAccountName);
        assertFalse(account.checkNameToEmboss());
        System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки наличия пробелов")
    @Description("Тест проверяет возврат ошибки в случае наличия пробела в начале строки")
    public void checkNameStartWithSpaceTest() {
        String newAccountName = " " + accountName;
        account = new Account(newAccountName);
        assertFalse(account.checkNameToEmboss());
        System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки наличия пробелов")
    @Description("Тест проверяет возврат ошибки в случае наличия пробела в конце строки")
    public void checkNameEndsWithSpaceTest() {
        String newAccountName = accountName + " ";
        account = new Account(newAccountName);
        assertFalse(account.checkNameToEmboss());
        System.out.println(account.getName());
    }

}
