package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String filename1 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/data.txt"; //reader.readLine();
//        String filename2 = "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/out.txt"; //reader.readLine();

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(filename1);
        FileOutputStream outputStream = new FileOutputStream(filename2);

        //byte[] buffer = new byte[1];

        ArrayList<Integer> list = new ArrayList();

        while (inputStream.available()>0)
        {
            list.add(inputStream.read());
        }

        for (int i=list.size()-1; i>=0; i--)
        {
            outputStream.write(list.get(i));
        }

        outputStream.close();
        inputStream.close();
    }
}
