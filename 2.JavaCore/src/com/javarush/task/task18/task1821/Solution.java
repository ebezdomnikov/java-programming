package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        //String filename = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1821/test1.txt";
//        1. Считывать с консоли ничего не нужно.
//        2. Создай поток для чтения из файла, который приходит первым параметром в main.
        FileInputStream fileInputStream = new FileInputStream(filename);
//        3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
        ArrayList<Byte> list = new ArrayList<>();

        byte[] buffer = new byte[1000];

        while (fileInputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = fileInputStream.read(buffer);
            for(int i=0; i<count; i++) {
                list.add(buffer[i]);
            }
        }

        Collections.sort(list);

        HashMap<Byte,Integer> counts = new HashMap<>();
        
        for (int i=0; i<list.size(); i++) {
            if (counts.containsKey(list.get(i))) {
                counts.put(list.get(i), counts.get(list.get(i))+1);
            } else {
                counts.put(list.get(i), 1);
            }
        }
        //        4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
        Map<Byte, Integer> map = new TreeMap<Byte, Integer>(counts);
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.println(new String(new byte[] {(byte)me2.getKey()}) + " " + me2.getValue());
        }


//        5. Поток для чтения из файла должен быть закрыт.

        fileInputStream.close();
    }
}
