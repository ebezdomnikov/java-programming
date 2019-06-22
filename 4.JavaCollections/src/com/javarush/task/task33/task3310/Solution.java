package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;
import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        StorageStrategy storageStrategy = new HashMapStorageStrategy();
        testStrategy(storageStrategy, 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> list = new HashSet<>();
        for(String string : strings) {
            list.add(shortener.getId(string));
        }

        return list;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> list = new HashSet<>();
        for(Long key : keys) {
            list.add(shortener.getString(key));
        }

        return list;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();

        for(int i=0; i< elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);
        Date start1 = new Date();
        Set<Long> keys = getIds(shortener, strings);
        Date end1 = new Date();
        Helper.printMessage(String.valueOf(end1.getTime() - start1.getTime()));

        Date start2 = new Date();
        Set<String> resultStrings = getStrings(shortener, keys);
        Date end2 = new Date();
        Helper.printMessage(String.valueOf(end2.getTime() - start2.getTime()));

        if (strings.size() == resultStrings.size()) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}


/*
6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества,
которое было возвращено методом getStrings. Если множества одинаковы, то выведи "Тест пройден.",
иначе "Тест не пройден.".
6.2.4. Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.
6.3. Проверь, что программа работает и тест пройден.
 */