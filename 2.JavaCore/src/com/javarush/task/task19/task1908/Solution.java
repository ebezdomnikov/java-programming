package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader freader = new BufferedReader(new FileReader(reader.readLine()));

        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        while (freader.ready()) {
            String s = freader.readLine();
            String[] parts = s.split(" ");
            for (int i=0; i<parts.length; i++) {
                try {
                    Integer.parseInt(parts[i]);
                    writer.write(parts[i] + " ");
                } catch (NumberFormatException e) {}
            }

        }

        writer.close();
        freader.close();

    }
}
