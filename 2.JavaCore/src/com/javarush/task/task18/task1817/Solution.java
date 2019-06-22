package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);//"/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1816/test.txt");
        int cAll = 0;
        int cSpace = 0;
        while (fileInputStream.available()>0) {
            cAll++;
            int data = fileInputStream.read();
            if (data==32) {
                cSpace++;
            }
        }
        double d = ((double)cSpace/(double)cAll)*100;
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println(f.format(d));
        fileInputStream.close();
    }
}
