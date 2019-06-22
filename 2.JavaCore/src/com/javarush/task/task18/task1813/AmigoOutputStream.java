package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {

    public static String fileName = "C:/tmp/result.txt";

    FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException
    {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    public void write(int b) throws IOException {
        this.fileOutputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        this.fileOutputStream.write(b, off, len);
    }

    public void write(byte[] b) throws IOException {
        this.fileOutputStream.write(b);
    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    public void close() throws IOException {
        this.fileOutputStream.flush();
        byte[] Str = "JavaRush © All rights reserved.".getBytes();
        this.fileOutputStream.write(Str);
        this.fileOutputStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
