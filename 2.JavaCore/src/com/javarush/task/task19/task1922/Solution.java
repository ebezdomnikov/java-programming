package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = reader.readLine();
        reader.close();

//        String filename = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1922/input.txt";

        BufferedReader fileReader = new BufferedReader(new FileReader(filename));


        while (fileReader.ready()) {
            String line = fileReader.readLine();
            int c = 0;
            for(int i=0; i<words.size(); i++) {

                String regex = "\\b"+words.get(i)+"\\b";

                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);

                if (
                        matcher.find()
                ) {
                    c++;
                }
            }
            if (c==2) {
                System.out.println(line);
                c = 0;
            }
        }

        fileReader.close();

    }
}
