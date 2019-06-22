package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);//"/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1816/test.txt");
        int lc = 0;
        while (fileInputStream.available()>0) {
            int data = fileInputStream.read();
            if ((data>=65 && data<=90) || (data>=97 && data<=122)) {
                lc++;
            }
        }
        System.out.println(lc);
        fileInputStream.close();
    }
}
