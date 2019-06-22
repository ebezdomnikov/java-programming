package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
//        1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
        while ( ! (filename = reader.readLine()).equals("exit")) {
//        2. Для каждого файла создай нить ReadThread и запусти ее.
            ReadThread readThread = new ReadThread(filename);
            readThread.start();
        }
//        Требования:



//        4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
//        5. Поток для чтения из файла в каждой нити должен быть закрыт.

    }

    public static class ReadThread extends Thread {

        private static HashMap sortByValues(HashMap map) {
            List list = new LinkedList(map.entrySet());
            // Defined Custom Comparator here
            Collections.sort(list, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return ((Comparable) ((Map.Entry) (o1)).getValue())
                            .compareTo(((Map.Entry) (o2)).getValue());
                }
            });

            // Here I am copying the sorted list in HashMap
            // using LinkedHashMap to preserve the insertion order
            HashMap sortedHashMap = new LinkedHashMap();
            for (Iterator it = list.iterator(); it.hasNext();) {
                Map.Entry entry = (Map.Entry) it.next();
                sortedHashMap.put(entry.getKey(), entry.getValue());
            }
            return sortedHashMap;
        }

        public ReadThread(String fileName) throws IOException {
            //implement constructor body
//        3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
            FileInputStream fileInputStream  = new FileInputStream(fileName);
            HashMap<Byte,Integer> counts = new HashMap<>();

            while(fileInputStream.available() > 0) {
                byte[] chars = new byte[fileInputStream.available()];
                fileInputStream.read(chars);
                for (int i=0; i<chars.length; i++) {
                    if (counts.containsKey(chars[i])) {
                        counts.put(chars[i], counts.get(chars[i])+1);
                    } else {
                        counts.put(chars[i], 1);
                    }
                }

                Map<Byte, Integer> map = sortByValues(counts);
                System.out.println("After Sorting:");
                Set set2 = map.entrySet();
                Iterator iterator2 = set2.iterator();
                Byte lastChar = 0;
                while(iterator2.hasNext()) {
                    Map.Entry me2 = (Map.Entry)iterator2.next();
                    lastChar = (byte)me2.getKey();
                    System.out.print(lastChar);
                    //System.out.println(me2.getValue());
                }

                resultMap.put(fileName, (int)lastChar);
            }
            fileInputStream.close();
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
