package com.javarush.task.task33.task3310.strategy;



import java.util.HashMap;

public class HashBiMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data;

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        return new Long(0);
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
