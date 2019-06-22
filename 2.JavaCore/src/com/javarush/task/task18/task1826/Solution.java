package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(args[0] + args[1] + args[2]);

        if (args[0].equals("-e")) {
            Encrypt encrypt = new Encrypt(args[1], args[2]);
        } else if (args[0].equals("-d")) {
            Decrypt encrypt = new Decrypt(args[1], args[2]);
        }
    }

    public static class Encrypt {
        public Encrypt(String input, String output) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(input);
            FileOutputStream fileOutputStream  = new FileOutputStream(output);

            BASE64Encoder encoder = new BASE64Encoder();
            encoder.encodeBuffer(fileInputStream, fileOutputStream);
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static class Decrypt {
        public Decrypt(String input, String output) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(input);
            FileOutputStream fileOutputStream  = new FileOutputStream(output);

            BASE64Decoder decoder = new BASE64Decoder();
            decoder.decodeBuffer(fileInputStream,fileOutputStream);
            fileInputStream.close();
            fileInputStream.close();
        }
    }


}
