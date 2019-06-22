package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        Long number = Long.valueOf(args[1]);
        String text = args[2];

        RandomAccessFile file = new RandomAccessFile(new File(fileName), "rw");
        if (number > file.length()) {
            file.seek(file.length());
        } else {
            file.seek(number);
        }

        file.write(text.getBytes());

        file.close();
    }
}
