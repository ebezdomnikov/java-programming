package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FunctionalTest {
    @Test
    public void testHashMapStorageStrategy() {
        StorageStrategy storageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        StorageStrategy storageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        StorageStrategy storageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        StorageStrategy storageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        StorageStrategy storageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        StorageStrategy storageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    public void testStorage(Shortener shortener) {
        Set<String> strings = new HashSet<>();

        strings.add("test");
        strings.add("test2");
        strings.add("test");

        Long listIds1 = shortener.getId("test");
        Long listIds2 = shortener.getId("test2");
        Long listIds3 = shortener.getId("test");


        Assert.assertNotEquals(listIds2,listIds1);
        Assert.assertNotEquals(listIds2,listIds3);
        Assert.assertEquals(listIds1, listIds3);

        String str1 = shortener.getString(listIds1);
        String str2 = shortener.getString(listIds2);
        String str3 = shortener.getString(listIds3);
        Assert.assertEquals("test", str1);
        Assert.assertEquals("test2", str2);
        Assert.assertEquals("test", str3);
    }
}
