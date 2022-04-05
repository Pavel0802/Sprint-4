package ru.yandex.practicum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;


public class Account {

    private static String name;

    public static String getName() {
        return name;
    }

    public Account(String name) {
        this.name = name;
    }

    public static Account createName() {
        int lengthFirstName = RandomUtils.nextInt(3, 16);
        int lengthSecondName = RandomUtils.nextInt(1, (18 - lengthFirstName));
        String firstName = RandomStringUtils.randomAlphabetic(lengthFirstName);
        String secondName = RandomStringUtils.randomAlphabetic(lengthSecondName);
        String name = firstName + " " + secondName;
        return new Account(name);
    }

    public static boolean checkNameToEmboss() {
        boolean check = false;
        if (name.length() >= 3 && name.length() <= 19) {
            if (name.trim().equals(name)) {
                int spacePosition = name.indexOf(" ");
                int spacePosition1 = name.lastIndexOf(" ");
                boolean space = (spacePosition == spacePosition1);
                check = space;
            }
        }
        return check;

    /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
    }
}
