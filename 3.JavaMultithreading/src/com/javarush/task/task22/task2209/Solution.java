package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        fileName = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2209/input.txt";
        reader.close();

        BufferedReader readerF = new BufferedReader(new FileReader(fileName));

        ArrayList<String> listFromFile = new ArrayList<>();

        while (readerF.ready()) {
            String[] words = readerF.readLine().trim().split(" ");
            for(int i=0; i<words.length; i++) {
                listFromFile.add(words[i]);
            }
        }

        String[] w = new String[listFromFile.size()];

        for(int i=0; i<listFromFile.size(); i++) {
            w[i] = listFromFile.get(i);
        }

        StringBuilder result = getLine(w);

        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder b  = new StringBuilder();

        if (words.length == 0) {
            return b;
        }

        Boolean isRun = true;
        int i = 0, appened = 0;
        String cur = words[0];
        ArrayList<String> listAppended = new ArrayList<>();
        while (isRun) {

            char lastLetter = cur.toLowerCase().charAt(cur.length()-1);

            for (int j = 0; j < words.length; j++) {
                if (j==i) continue;
                if (words[j].toLowerCase().charAt(0) == lastLetter ) {
                    listAppended.add(words[j]);
                    //i=0;
                    cur = words[j];
                    appened++;
                }
            }
            i++;
            if (i>=words.length || appened >=words.length) {
                isRun = false;
            }
        }

        Boolean first = true;

        for (int k=0; k<listAppended.size(); k++) {
            if ( ! first) {
                b.append(" ");
            }

            b.append(listAppended.get(k));

            first = false;
        }

        return b;
    }
}
