package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {

    static float slow;
    static float fast;

    public static void main(String[] args) {
        slow = 1000;
        fast = 1;
        int year = 1;
        while (!hasSolution()) {

            slow = (slow * 2);

            slow = slow - (float) (slow * 0.4);
            System.out.println(slow);

            fast = (fast * 2);
            fast = fast - (float) (fast * 0.3);

            year++;
            System.out.println(slow + " " + fast);
            System.out.println(year);
        }
//        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
    }

    public static boolean hasSolution()
    {
        return fast > slow;
    }
}