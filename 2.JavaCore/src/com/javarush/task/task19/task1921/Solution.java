package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

//        FileReader fileReader = new FileReader("/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1921/input.txt");

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        BufferedReader reader = new BufferedReader(fileReader);

        HashMap<String, Float> map = new HashMap();

        while (reader.ready()) {
            String[] splitted = reader.readLine().split(" ");
            Float value;

            int year = Integer.parseInt(splitted[splitted.length-1]);
            int month = Integer.parseInt(splitted[splitted.length-2]);
            int day = Integer.parseInt(splitted[splitted.length-3]);
            Date birthday = new Date(year-1900, month-1, day);
            String name = "";
            for(int i = 0; i<splitted.length-3; i++) {
                if (name.equals("")) {
                    name = splitted[i];
                } else {
                    name = name + " " + splitted[i];
                }
            }
            Person person = new Person(name, birthday);
            PEOPLE.add(person);
        }

        reader.close();

//        for (int c=0; c < PEOPLE.size(); c++) {
//            System.out.println(PEOPLE.get(c).getBirthday());
//        }
    }
}
