package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Timer;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        out.write(getRanmdomLetter().toLowerCase().getBytes());
        out.write(String.valueOf(getRanmdomNumber()).getBytes());
        out.write(getRanmdomLetter().toUpperCase().getBytes());

        for (int i=3; i<8; i++) {
            if (numberOrString()) {
                out.write(getRanmdomLetter().getBytes());
            } else {
                out.write(String.valueOf(getRanmdomNumber()).getBytes());
            }
        }

        return out;
    }

    private static String getRanmdomLetter() {
        int random = (int)Math.round(25 * Math.random());
        boolean letterCase = Math.round(1 * Math.random()) == 1;
        String letter = String.valueOf((char)(random+65));

        if (letterCase) {
            return letter.toLowerCase();
        }

        return letter;
    }

    private static int getRanmdomNumber() {
        return (int)Math.round(9 * Math.random());
    }


    private static boolean numberOrString() {
        return Math.round(1 * Math.random()) == 1;
    }
}