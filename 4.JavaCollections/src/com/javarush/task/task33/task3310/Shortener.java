package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0l;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String value) {
        if (storageStrategy.containsValue(value)) {
            return storageStrategy.getKey(value);
        }

        lastId++;

        storageStrategy.put(lastId, value);

        return lastId;
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
