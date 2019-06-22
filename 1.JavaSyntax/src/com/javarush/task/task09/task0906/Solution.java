package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        System.out.println(
                Thread.currentThread().getStackTrace()[2].getClassName() + ": " +
                Thread.currentThread().getStackTrace()[2].getMethodName() + ": " + s
        );
//        1. Метод log должен выводить сообщение на экран.
//        2. Выведенное сообщение должно содержать имя класса, метод которого вызвал метод log.
//        3. Выведенное сообщение должно содержать имя метода, который вызвал метод log.
//        4. Выведенное сообщение должно содержать переданное сообщение.
//        5. Вывод должен соответствовать примеру из задания.
    }
}
