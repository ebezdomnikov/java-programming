package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

//        Требования:
//        1. Программа должна считать имя файла с консоли.


        int number = Integer.parseInt(args[0]);

//        2. Создай для файла поток для чтения.
        FileInputStream fileInputStream  = new FileInputStream(filename);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String readString;
        long val;
        readString = bufferedReader.readLine();

        while ( readString != null) {
          //  val = Math.round(Double.parseDouble(readString));
            String[] splited = readString.split("\\s+");
            if (splited[0].equals(Integer.toString(number))) {
                System.out.println(readString);
            }
            readString = bufferedReader.readLine();
        }

//        5. Созданные для файлов потоки должны быть закрыты.
        bufferedReader.close();
    }
}
