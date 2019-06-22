package com.javarush.task.task19.task1907;
/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        BufferedReader freader = null;
        String filename;
        reader = new BufferedReader(new InputStreamReader(System.in));
        filename = reader.readLine();
        freader = new BufferedReader(new FileReader(filename));
        int countWorld = 0;
        while (freader.ready()) {
            String line = freader.readLine();
            line = line.replaceAll("\\p{Punct}", " ");
            String[] array = line.split(" ");
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("world"))
                    countWorld++;
            }
        }
        System.out.print(countWorld);
        reader.close();
        freader.close();
    }
}