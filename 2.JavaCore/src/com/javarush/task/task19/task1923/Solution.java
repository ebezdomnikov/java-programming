package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        String file1 = args[0];
        String file2 = args[1];

//        String file1 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1923/input.txt";
//        String file2 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1923/output.txt";
        BufferedReader readerFileOne = new BufferedReader(new FileReader(file1));
        BufferedWriter writerFileTwo = new BufferedWriter(new FileWriter(file2));

        String matchedString = "";

        while (readerFileOne.ready()) {

            String lines[] = readerFileOne.readLine().split(" ");

            for(int i=0; i<lines.length; i++) {

                String word = lines[i];

                String shrinkString = word.replaceAll("[^0-9]", "");

                if ( ! shrinkString.equals("") && Integer.parseInt(shrinkString) >= Integer.MIN_VALUE) {
                    matchedString += word + " ";
                }
            }

        }

        writerFileTwo.write(matchedString);
        writerFileTwo.close();
        readerFileOne.close();
    }
}
