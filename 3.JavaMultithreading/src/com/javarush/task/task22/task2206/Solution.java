package com.javarush.task.task22.task2206;

import java.util.Date;

/* 
Форматирование даты
*/
public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59 - dd:MM:yy hh:mm:ss
    }

    public static String getFormattedString() {
        //%1$tm %1$te,%1$tY"
        //"%tY-%tm-%td".
        return "%td:%tm:%ty %tH:%tM:%tS";
    }
}
