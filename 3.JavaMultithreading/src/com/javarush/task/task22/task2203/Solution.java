package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }

        int counter = 0;
        for (int i=0; i<string.length(); i++) {
            if (string.charAt(i) == 9) {
                counter++;
            }
        }

        if (counter < 2) {
            throw new TooShortStringException();
        }

        String[] s = string.split("\t");


        return s[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
