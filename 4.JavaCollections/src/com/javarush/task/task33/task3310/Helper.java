package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    public static String generateRandomString() {
//      Генерировать случайную строку. Воспользуйся для этого классами SecureRandom и BigInteger.
//      Подсказка: гугли запрос "random string java". Строка может состоять из цифр и любой
//      из 26 маленьких букв английского алфавита.
       return new BigInteger(130, new SecureRandom()).toString(36);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
