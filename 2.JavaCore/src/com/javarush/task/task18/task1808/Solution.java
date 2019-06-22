package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(filename1);

        FileOutputStream outputStream1 = new FileOutputStream(filename2);

        FileOutputStream outputStream2 = new FileOutputStream(filename3);

        int part = inputStream1.available()/2;
        int part2 = inputStream1.available() - part;

        byte[] buffer1 = new byte[part];
        byte[] buffer2 = new byte[part2];

        if (inputStream1.available()>0) {
            //читаем весь файл одним куском
            int count = inputStream1.read(buffer1);
            outputStream1.write(buffer1, 0, count);
            int count2 = inputStream1.read(buffer2);
            outputStream2.write(buffer2, 0, count2);
        }

        outputStream2.close();
        outputStream1.close();
        inputStream1.close();
        reader.close();
    }
}
