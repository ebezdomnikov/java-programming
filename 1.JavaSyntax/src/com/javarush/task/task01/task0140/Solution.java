package com.javarush.task.task01.task0140;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) {
        int a;

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        a = scanner.nextInt();

        System.out.println(a * a);
    }
}