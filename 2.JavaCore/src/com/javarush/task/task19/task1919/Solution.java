package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

//                FileReader fileReader = new FileReader("/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1920/input.txt");

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        HashMap<String, Float> map = new HashMap();

        while (reader.ready()) {
            String[] splitted = reader.readLine().split(" ");
            Float value;

            if (map.containsKey(splitted[0])) {
                value = map.get(splitted[0]);
                value += Float.parseFloat(splitted[1]);
                map.remove(splitted[0]);
                map.put(splitted[0], value);
            } else {
                value = Float.parseFloat(splitted[1]);
                map.put(splitted[0], value);
            }
        }

        reader.close();


        Map<String, Float> treeMap = new TreeMap<>(map);

        for (Map.Entry<String, Float> pair : treeMap.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());

    }
}
