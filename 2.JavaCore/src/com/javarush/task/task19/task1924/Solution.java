package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();

//        String fileName = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1924/input.txt";

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        Pattern pattern = Pattern.compile("^[\\d]+$", Pattern.CASE_INSENSITIVE);


        while (fileReader.ready()) {

            String parts[] = fileReader.readLine().split(" ");
            String newString = "";

            for (int i=0; i<parts.length; i++) {
                Matcher matcher = pattern.matcher(parts[i]);
                String part = parts[i];
                if (matcher.find()) {
                    int index = Integer.parseInt(parts[i]);
                    if (index<map.size() && index>=0) {
                        part = map.get(index);
                    }
                }

                if (newString.isEmpty()) {
                    newString = part;
                } else {
                    newString = newString + " " + part;
                }
            }

            System.out.println(newString);
        }

        fileReader.close();
    }
}
