package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.*;


class MyReader
{
    protected ByteArrayOutputStream outputStream;

    MyReader (ByteArrayOutputStream outputStream)
    {
        this.outputStream = outputStream;
    }

    public String addAds()
    {
        String resultString = "";
        String[] splitted = this.outputStream.toString().split("\n");
        for (int i = 0; i<splitted.length; i++) {
            if (i>0 && i % 2 == 0) {
                resultString = resultString + "JavaRush - курсы Java онлайн\n";
            }
            resultString = resultString + splitted[i] + "\n";
        }
        return resultString;
    }
}

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        MyReader reader = new MyReader(outputStream);

        //Возвращаем все как было
        System.setOut(consoleStream);

        //выводим ее в консоль
        System.out.println(reader.addAds());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
