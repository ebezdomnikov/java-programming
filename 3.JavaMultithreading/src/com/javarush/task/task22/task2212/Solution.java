package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null||telNumber.equals("")) return false;
        Pattern pattern1 = Pattern.compile("\\+\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Pattern pattern2 = Pattern.compile("\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Matcher matcher1 = pattern1.matcher(telNumber);
        Matcher matcher2 = pattern2.matcher(telNumber);
        if (matcher1.matches()){

            if (telNumber.replaceAll("\\D","").length()==12){

                return true;

            }
            return false;
        }
        if (matcher2.matches()) {

            if (telNumber.replaceAll("^\\D", "").length() == 10) {

                return true;

            }
            return false;
        }



        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567") + " == true");
        System.out.println(checkTelNumber("+38(050)1234567") + " == true");
        System.out.println(checkTelNumber("+38050123-45-67") + " == true");
        System.out.println(checkTelNumber("050123-4567") + " == true");
        System.out.println(checkTelNumber("+38)050(1234567") + " == false");
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7") + " == false");
        System.out.println(checkTelNumber("050ххх4567") + " == false");
        System.out.println(checkTelNumber("050123456") + " == false");
        System.out.println(checkTelNumber("(0)501234567") + " == false");
    }
}
