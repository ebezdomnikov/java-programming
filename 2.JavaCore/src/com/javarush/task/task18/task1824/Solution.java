package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.*;

public class Solution {
    static boolean isStop = false;
    public static void main(String[] args) throws IOException, InterruptedException {

//        1. Программа должна считывать имена файлов с консоли.
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename;
//        1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
            while (true) {
//        2. Для каждого файла создай нить ReadThread и запусти ее.
                filename = reader.readLine();
                FileInputStream fileInputStream = null;
                try {
                    //        2. Для каждого файла нужно создавать поток для чтения.
                    fileInputStream = new FileInputStream(filename);
                    fileInputStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println(filename);
                    reader.close();
                    return;
                }
            }
    }
}
