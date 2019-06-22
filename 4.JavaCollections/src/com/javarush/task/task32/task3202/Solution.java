package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task32/task3202/testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringWriter stringWriter = new StringWriter();
        boolean hasSomething = false;
        while (reader.ready()) {
            hasSomething = true;
            stringWriter.write(reader.readLine());
        }

        if (!hasSomething) {
            stringWriter.write("");
        }

        return stringWriter;
    }
}