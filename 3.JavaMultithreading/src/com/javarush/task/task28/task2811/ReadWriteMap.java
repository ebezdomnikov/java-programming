package com.javarush.task.task28.task2811;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public ReadWriteMap(Map<K, V> map) {
        this.map = map;
    }

    public V put(K key, V value) {
        try {
            // В методе put должен быть вызван метод lock на объекте writeLock.
            writeLock.lock();
            return map.put(key, value);
        } finally {
            // В методе put в блоке finally должен быть вызван метод unlock на объекте writeLock.
            writeLock.unlock();
        }
    }

    public V get(K key) {
        try {
            //В методе get должен быть вызван метод lock на объекте readLock.
            readLock.lock();
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }
}
