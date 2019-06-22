package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;
import org.junit.Assert;
import org.junit.Test;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date timeStart = new Date();
        for(String string : strings) {
            ids.add(shortener.getId(string));
        }

        return new Date().getTime() - timeStart.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date timeStart = new Date();
        for(Long key : ids) {
            strings.add(shortener.getString(key));
        }

        return new Date().getTime() - timeStart.getTime();
    }
    @Test
    public void testHashMapStorage() {
        StorageStrategy storageStrategy1 = new HashMapStorageStrategy();
        Shortener shortener1 = new Shortener(storageStrategy1);

        StorageStrategy storageStrategy2 = new HashBiMapStorageStrategy();
        Shortener shortener2 = new Shortener(storageStrategy2);

        Set<String> origStrings = new HashSet<>();
        Set<Long> outIds = new HashSet<>();
        Set<String> outStrings = new HashSet<>();

        int elementsNumber = 10000;
        for(int i=0; i< elementsNumber; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long time1 = getTimeForGettingIds(shortener1, origStrings, outIds);
        long time2 = getTimeForGettingIds(shortener2, origStrings, outIds);
        Assert.assertTrue(time1 > time2);

        long time3 = getTimeForGettingStrings(shortener1, outIds, outStrings);
        long time4 = getTimeForGettingStrings(shortener2, outIds, outStrings);
        Assert.assertEquals(time3, time4, 30);
//        long time2 = getTimeForGettingStrings(shortener1, outIds, outStrings);
    }
}
