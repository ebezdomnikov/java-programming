package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedSet;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/test.txt";

        InputStream inputStream = new FileInputStream(fileName);

        load(inputStream);


//        1. Метод fillInPropertiesMap должен считывать данные с консоли.
//        2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
//        3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
//        4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
//        5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.


    }

    public void printProperties()
    {
        for(Map.Entry<String, String> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties property = new Properties();
        property.putAll(properties);
        property.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Properties property = new Properties();
        property.load(inputStream);
        for(Map.Entry<Object, Object> pair: property.entrySet()){
            properties.put(pair.getKey().toString(), pair.getValue().toString());
        }

//        if (reader.ready()) {
//            properties.clear();
//            while (reader.ready()) {
//                //ключ=значение, ключ = значение, ключ:значение и ключ : значение
//                String line = reader.readLine();
//
//                String parts[] = line.split(" : ");
//                if (parts.length == 1) {
//                    parts = line.split(":");
//                }
//
//                if (parts.length == 1) {
//                    parts = line.split(" = ");
//                }
//
//                if (parts.length == 1) {
//                    parts = line.split("=");
//                }
//
//                if (parts.length == 1 || parts.length !=2) {
//                    continue;
//                }
//
//                properties.put(parts[0], parts[1]);
//            }
//        }
        reader.close();
    }

    public static void main(String[] args) throws Exception {
//        Solution solution = new Solution();
//        solution.fillInPropertiesMap();
//        solution.printProperties();
//        OutputStream outputStream = new FileOutputStream("/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/out.txt");
//        solution.save(outputStream);
    }
}
