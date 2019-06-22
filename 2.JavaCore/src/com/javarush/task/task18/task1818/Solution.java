package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //        1. Программа должна три раза считать имена файлов с консоли.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileWrite = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/test1.txt";// reader.readLine();
//        String fileRead1 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/test2.txt";// reader.readLine();
//        String fileRead2 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/test3.txt";// reader.readLine();
        String fileWrite = reader.readLine();
        String fileRead1 = reader.readLine();
        String fileRead2 = reader.readLine();

//        2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
        FileOutputStream fileOutputStream = new FileOutputStream(fileWrite);
        FileInputStream fileInputStream1 = new FileInputStream(fileRead1);
        FileInputStream fileInputStream2 = new FileInputStream(fileRead2);
//        3. Содержимое второго файла нужно переписать в первый файл.
        if (fileInputStream1.available()>0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[fileInputStream1.available()];
            int count = fileInputStream1.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }
//        4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
        if (fileInputStream2.available()>0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[fileInputStream2.available()];
            int count = fileInputStream2.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }
//        5. Созданные для файлов потоки должны быть закрыты.
        fileOutputStream.close();
        fileInputStream1.close();
        fileInputStream2.close();
    }
}
