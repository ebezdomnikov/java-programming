package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String result = outputStream.toString().replaceAll("[\\n|\\r\\n|\\r]","");


        Matcher m = Pattern.compile("^(\\d+)\\s(\\+|\\-|\\*)\\s(\\d+)\\s=\\s$")
                .matcher(result);

        if (m.find()) {

            int firstNumber = Integer.parseInt(m.group(1));
            int secondNumber = Integer.parseInt(m.group(3));
            String operation = m.group(2);
            int resultOf = 0;

            if (operation.equals("+")) {
                resultOf = firstNumber + secondNumber;
            } else if (operation.equals("-")) {
                resultOf = firstNumber - secondNumber;
            } else if (operation.equals("*")) {
                resultOf = firstNumber * secondNumber;
            }

            result = result + String.valueOf(resultOf);
        }
        //Возвращаем все как было
        System.setOut(consoleStream);

        //выводим ее в консоль
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

