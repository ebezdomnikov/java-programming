package com.javarush.task.task26.task2613;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> map = new HashMap<>();
    
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        Collection<CurrencyManipulator> collection = new ArrayList<>();
        for(Map.Entry<String, CurrencyManipulator> entry : map.entrySet()) {
            collection.add(entry.getValue());
        }

        return collection;
    }

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (!map.containsKey(currencyCode))
            map.put(currencyCode, new CurrencyManipulator(currencyCode));

        return map.get(currencyCode);
    }
}
