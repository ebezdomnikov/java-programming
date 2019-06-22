package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
//        String fileName = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1926/input.txt";

        BufferedReader fileReader = new BufferedReader(
                new FileReader(
                        fileName
                )
        );

        while (fileReader.ready()) {

            char line[] = fileReader.readLine().toCharArray();
            String newLine = "";

            for (int i=line.length-1; i>=0; i--) {
                newLine += line[i];
            }

            System.out.println(newLine);

        }

        fileReader.close();
    }
}
