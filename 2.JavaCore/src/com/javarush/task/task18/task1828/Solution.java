package com.javarush.task.task18.task1828;

/*
Прайсы
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
//        args = new String[]{"-d", "198478"};
//        args = new String[]{"-c", "30", "8", "4"};
//        args = new String[]{"-c", "Куртка для сноубордистов, разм", "10173.99", "1234"};
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            //String fileName = "crud.txt";
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int updateId = -1;
                int lineNum = 0;
                int operation = args[0].equals("-u")?1:2;
                List<String> list = new LinkedList<>();
                while ((line = fileReader.readLine()) != null) {
                    list.add(line);
                    if (args[1].equals(line.substring(0, 8).trim())) {
                        updateId = lineNum;
                    }
                    lineNum++;
                }
                lineNum = 0;
                try (FileOutputStream fos = new FileOutputStream(fileName)) {
                    for (String s : list) {
                        if (operation == 1) {
                            if (lineNum == updateId) {
                                fos.write(String.format("%-8s%-30s%-8s%-4s%n", args[1], args[2], args[3], args[4]).getBytes());
                            } else {
                                fos.write((String.format("%s%n", s)).getBytes());
                            }
                        } else if(operation == 2) {
                            if (lineNum != updateId) {
                                fos.write((String.format("%s%n", s)).getBytes());
                            }
                        }
                        lineNum++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
