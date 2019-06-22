package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String filename1;
        String filename2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        1. Программа должна два раза считать имена файлов с консоли.
        filename1 = reader.readLine();
        filename2 = reader.readLine();

//        filename1 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1819/test1.txt";
//        filename2 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1819/test2.txt";


        FileInputStream fileInputStream1 = new FileInputStream(filename1);

        byte[] bufferFirst = new byte[0];
        int countFirst = 0;
//        2. Для первого файла создай поток для чтения и считай его содержимое.
        if (fileInputStream1.available()>0) {
            //читаем весь файл одним куском
            bufferFirst = new byte[fileInputStream1.available()];
            countFirst = fileInputStream1.read(bufferFirst);
        }

        fileInputStream1.close();

//        3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
        FileOutputStream fileOutputStream1 = new FileOutputStream(filename1);
        FileInputStream fileInputStream2 = new FileInputStream(filename2);
//        4. Содержимое первого и второго файла нужно объединить в первом файле.
        if (fileInputStream2.available()>0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[fileInputStream2.available()];
            int count = fileInputStream2.read(buffer);
            fileOutputStream1.write(buffer, 0, count);
            fileOutputStream1.write(bufferFirst, 0, countFirst);
        }
        fileInputStream2.close();
        fileOutputStream1.close();
//        5. Сначала должно идти содержимое второго файла, затем содержимое первого.
//        6. Созданные для файлов потоки должны быть закрыты.


    }
}
