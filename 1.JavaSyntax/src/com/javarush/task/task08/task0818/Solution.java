package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap()
    {
        HashMap<String, Integer> map = new HashMap();

        map.put("Test",500);
        map.put("Test1",300);
        map.put("Test4",200);
        map.put("Test5",300);
        map.put("Test6",250);
        map.put("Test7",100);
        map.put("Test8",6000);
        map.put("Test9",900);
        map.put("Test10",2000);
        map.put("Test11",750);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> result = new HashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() >= 500)
            {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        map.clear();
        map.putAll(result);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
    }
}