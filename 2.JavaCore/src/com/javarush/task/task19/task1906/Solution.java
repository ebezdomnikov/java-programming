package com.javarush.task.task19.task1906;

/* 
Четные байты
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String filename1 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1906/test1.txt"; //reader.readLine();
//        String filename2 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1906/test2.txt";// reader.readLine();
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        FileReader file1 = new FileReader(filename1);
        FileWriter file2 = new FileWriter(filename2);
        int i = 1;
        while (file1.ready()) {
            int bb = file1.read();

            if (i % 2 == 0) {
                System.out.println(bb);
                file2.write(bb);
            }
            i++;
        }


        file1.close();
        file2.close();

    }
}
