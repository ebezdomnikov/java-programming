package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
//        1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
//        2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
        HashMap<Integer, String> files = new HashMap<>();
        String mainfile = null;
        while ( ! (filename = reader.readLine()).equals("end")) {
        //while ( ! ("filename").equals("end")) {
            File f = new File(filename);

            String curreFilename = f.getName();

            if (mainfile == null) {
                String[] parts = curreFilename.split("[.]");
                mainfile = f.getName();
                mainfile = f.getParent() + "/" + curreFilename.substring(0, curreFilename.lastIndexOf("."));
                //System.out.println(mainfile);
            }

            String[] parts = curreFilename.split("[.]");
            Integer fileNo = Integer.parseInt(parts[parts.length-1].replaceAll("[^0-9]",""));
            //System.out.println(curreFilename);
            files.put(fileNo, filename);
        }
        Map<Integer, String> map = new TreeMap<>(files);
        //System.out.println("After Sorting:");
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();

        FileOutputStream fileOutputStream = new FileOutputStream(mainfile);
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            //System.out.print(me2.getKey() + ": ");
            //System.out.println(me2.getValue());
            filename = (String)me2.getValue();
            FileInputStream fileInputStream = new FileInputStream(filename);
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            byte[] buffer = new byte[1024];
            if (fileInputStream.available()>0) {
                //читаем весь файл одним куском
                int count = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, count);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
        reader.close();
    }
}
