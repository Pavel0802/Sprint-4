package ru.yandex.practicum;

public class Praktikum {


    public static void main(String[] args) {

        String accountName;
        Account account = Account.createName();
        boolean successCreate = Account.checkNameToEmboss();
        if (successCreate = true) {
            accountName = account.getName();
            System.out.println("Dear, " + accountName + ", the card in your name has been issued.");
        } else {
            System.out.println("Name is incorrect. Try again");
        }
        /*
             В этом методе заложи логику работы с классом Account.
             Нужно создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
             и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
         */

    }
}
