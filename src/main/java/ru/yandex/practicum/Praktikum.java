package ru.yandex.practicum;

public class Praktikum {


    public static void main(String[] args) {

        String accountName;
        Account account = Account.createName();
        boolean successCreate = Account.checkNameToEmboss();
        accountName = account.getName();
        System.out.println("Уважаемый " + accountName + " карта на ваше имя выпущена.");
        System.out.println(successCreate);

        /*
             В этом методе заложи логику работы с классом Account.
             Нужно создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
             и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
         */

    }
}
