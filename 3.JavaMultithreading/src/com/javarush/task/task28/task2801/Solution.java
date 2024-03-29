package com.javarush.task.task28.task2801;

/*
Осваиваем switch
*/
public class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* output
        it's E1.C
        undefined
        it's E2.D
         */
    }

//    Вывод для E1.A - "it's E1.A"
//    Вывод для E1.B - "it's E1.B"
//    Вывод для E1.C - "it's E1.C"
//    Вывод для E1.Y - "it's E1.Y"
//    Вывод для E2.D - "it's E2.D"
//    Вывод для E2.E - "it's E2.E"
//    Вывод для E2.F - "it's E2.F"

    public static void switchTest(Enum obj) {
        switch (obj.getClass().getSimpleName()) {
            case "E1":
                System.out.println("it's " + obj.getClass().getSimpleName() + "." + obj);
                break;
            case "E2":
                System.out.println("it's " + obj.getClass().getSimpleName() + "." + obj);
                break;
            default:
                System.out.println("undefined");

        }
    }
}
