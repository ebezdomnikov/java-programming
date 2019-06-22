package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];

//        String file1 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1925/input.txt";
//        String file2 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1925/output.txt";
        BufferedReader readerFileOne = new BufferedReader(new FileReader(file1));
        BufferedWriter writerFileTwo = new BufferedWriter(new FileWriter(file2));

        String matchedString = "";

        while (readerFileOne.ready()) {

            String line = "";

            String words[] = readerFileOne.readLine().split(" ");

            for (int i=0; i<words.length; i++) {

                line = words[i];

                if (line.length() > 6) {
                    if (matchedString.equals("")) {
                        matchedString = line;
                    } else {
                        matchedString = matchedString + "," + line;
                    }
                }
            }
        }

        writerFileTwo.write(matchedString);
        writerFileTwo.close();
        readerFileOne.close();

    }
}
