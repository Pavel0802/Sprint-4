package ru.yandex.practicum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertFalse("The name must be shorter than 19 characters",account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки при несоответствии количества символов")
    @Description("Тест проверяет возврат ошибки в случае длины полного имени пользователя менее 3 символов")
    public void checkNameBelowThreeCharTest() {
        String newAccountName = accountName.substring(0, 2);
        account = new Account(newAccountName);
        assertFalse("The name must be longer than 3 characters",account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка возможности создать имя пользователя при пограничных значениях")
    @Description("Тест проверяет возможность создать имя пользователя длиной 3 символа")
    public void checkNameThreeCharTest() {
        String newAccountName = accountName.substring(0, 3);
        account = new Account(newAccountName);
        assertTrue("The name is correct, the account must be created", account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка возможности создать имя пользователя при пограничных значениях")
    @Description("Тест проверяет возможность создать имя пользователя длиной 19 символа")
    public void checkNameNineteenCharTest() {
        String newAccountName = accountName + RandomStringUtils.randomAlphabetic(19 - accountName.length());
        account = new Account(newAccountName);
        assertTrue("The name is correct, the account must be created", account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки при пустой строке")
    @Description("Тест проверяет возврат ошибки в случае возврата пустой строки")
    public void checkEmptyNameTest() {
        String newAccountName = "";
        account = new Account(newAccountName);
        assertFalse("An empty name should not be created", account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки при выводе null вместо имени")
    @Description("Тест проверяет возврат NullPointerException при выводе null вместо имени")
    public void checkEmptyAccountTest() throws Exception {
        account = new Account(null);
        assertFalse("Need to choose a name", account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки наличия пробелов")
    @Description("Тест проверяет возврат ошибки в случае наличия более одного пробела")
    public void checkNameTwoSpaceTest() {
        int spacePosition = accountName.indexOf(" ");
        String newAccountName = accountName.substring(0, spacePosition + 2) + " " + accountName.substring(spacePosition + 1, accountName.length());
        account = new Account(newAccountName);
        assertFalse("There should not be more than 2 spaces", account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки наличия пробелов")
    @Description("Тест проверяет возврат ошибки в случае наличия пробела в начале строки")
    public void checkNameStartWithSpaceTest() {
        String newAccountName = " " + accountName;
        account = new Account(newAccountName);
        assertFalse("the space should not be at the beginning of the string",account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

    @Test
    @DisplayName("Проверка ошибки наличия пробелов")
    @Description("Тест проверяет возврат ошибки в случае наличия пробела в конце строки")
    public void checkNameEndsWithSpaceTest() {
        String newAccountName = accountName + " ";
        account = new Account(newAccountName);
        assertFalse("the space should not be at the end of the string", account.checkNameToEmboss());
        //System.out.println(account.getName());
    }

}
