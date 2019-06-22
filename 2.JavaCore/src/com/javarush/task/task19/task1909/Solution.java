package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.out.println("sdfd.fd..fd.fd.fd.f.df".replaceAll("\\.","!"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader freader = new BufferedReader(new FileReader(reader.readLine()));

        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        while (freader.ready()) {
            String s = freader.readLine();
            writer.write(s.replaceAll("\\.","!"));
        }

        writer.close();
        freader.close();

    }
}
