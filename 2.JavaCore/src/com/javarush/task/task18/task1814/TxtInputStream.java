package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        Path p = Paths.get(fileName);
        String fileName1 = p.getFileName().toString();
        int i = fileName1.lastIndexOf('.');
        if (i > 0) {
            if (fileName1.substring(i+1).equals("txt"))
            {
                return;
            }
        }
        super.close();
        throw new UnsupportedFileNameException();
    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException  {
        //TxtInputStream text = new TxtInputStream("/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1814/test.txt1");
    }
}

