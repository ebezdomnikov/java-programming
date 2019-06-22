package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
//        Требования:
//        1. Программа должна два раза считать имена файлов с консоли.
        String filename1;
        String filename2;

        int number = 1;// Integer.parseInt(args[0]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        1. Программа должна два раза считать имена файлов с консоли.
        filename1 = reader.readLine();
        filename2 = reader.readLine();

//        filename1 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/test1.txt";
//        filename2 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/test2.txt";


//        2. Для первого файла создай поток для чтения. Для второго - поток для записи.
//        InputStreamReader inputStreamReader  = new InputStreamReader(new FileInputStream(filename1));
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filename1));
//
//
//        char[] bufferFirst = new char[0];
//        char[] chars = new char[50];
//        int countFirst = 0;
//        if (countFirst != -1) {
//            //читаем весь файл одним куском
//            countFirst = inputStreamReader.read(chars,0,20);
//            System.out.println(Arrays.toString(chars));
//        }
//        if (1==1) return;
//        System.out.println(Arrays.toString(bufferFirst));

        FileInputStream fileInputStream  = new FileInputStream(filename1);
        FileOutputStream fileOutputStream = new FileOutputStream(filename2);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        String readString;
        long val;
        readString = bufferedReader.readLine();

        while ( readString != null) {
//        3. Считать числа из первого файла, округлить их и записать через пробел во второй.
//        4. Должны соблюдаться принципы округления, указанные в задании.

            val = Math.round(Double.parseDouble(readString));
            bufferedWriter.write(((Long)val).toString() + " ");
//            3.49 — 3
//            3.50 — 4
//            3.51 — 4
//            -3.49 — -3
//            -3.50 — -3
//            -3.51 — -4
            readString = bufferedReader.readLine();
        }

//        5. Созданные для файлов потоки должны быть закрыты.
        bufferedWriter.close();
        bufferedReader.close();
    }
}
