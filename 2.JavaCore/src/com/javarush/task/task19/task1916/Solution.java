package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(reader.readLine());
        FileReader file2 = new FileReader(reader.readLine());

        reader.close();

        Scanner file1Scan = new Scanner(file1);
        Scanner file2Scan = new Scanner(file2);

        List<String> file1Lines = new ArrayList<>();
        List<String> file2Lines = new ArrayList<>();

        while (file1Scan.hasNextLine()) {
            file1Lines.add(file1Scan.nextLine());
        }

        while (file2Scan.hasNextLine()) {
            file2Lines.add(file2Scan.nextLine());
        }

        //boolean addSecond = (file2Lines.size() > file1Lines.size());

        int i=0;
        while (i<file1Lines.size()) {
            LineItem lineItem;
            if (file2Lines.size()>0 && file1Lines.get(i).equals(file2Lines.get(0))) {
                lineItem = new LineItem(Type.SAME, file1Lines.get(i));
                file2Lines.remove(0);
            } else if(file2Lines.size()>1 && file1Lines.get(i).equals(file2Lines.get(1))) {
                lineItem = new LineItem(Type.ADDED, file2Lines.get(0));
                file2Lines.remove(0);
                i--;
            } else {
                lineItem = new LineItem(Type.REMOVED, file1Lines.get(i));
            }
            i++;
            lines.add(lineItem);
        }

//        if (file2Lines.size() > file1Lines.size()) {
//            for (int k=)
//        }

        for (int j=0; j<file2Lines.size(); j++) {
            LineItem lineItem = new LineItem(Type.ADDED, file2Lines.get(j));
            lines.add(lineItem);
        }


//        for (int j=0; j<lines.size(); j++) {
//            LineItem lineItem = lines.get(j);
//            System.out.println(lineItem.type + " " + lineItem.line);
//        }


        file2.close();
        file1.close();

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
