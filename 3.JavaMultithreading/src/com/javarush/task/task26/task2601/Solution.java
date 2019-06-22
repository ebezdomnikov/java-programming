package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static int mediana;

    public static void main(String[] args) {
//        Integer[] a = new Integer[5];
//
//        a[2] = 15;
//        a[0] = 13;
//        a[1] = 8;
//        a[3] = 5;
//        a[4] = 17;
//
//        a = sort(a);
//
//        for(int i=0; i< a.length; i++) {
//            System.out.println(a[i]);
//        }

//        17, 15, 13, 8,  5
//        17 - 13 = 4
//        15 - 13 = 2
//        13 - 13 = 0
//        8 - 13 = -5
//        5 - 13 = -8
//        //13, 15, 17, 8,  5
//        0 2 4 -4 -8
//        13 15 17 8 5
    }

    public static Integer[] sort(Integer[] array) {

        Arrays.sort(array);

        //int mediana = 0;
        if (array.length % 2 == 0) {
            mediana = (array[array.length/2] + array[array.length/2 - 1])/2;
        } else {
            mediana = array[array.length/2];
        }


        Comparator<Integer> compareByMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer res1 = Math.abs(o1 - mediana);
                Integer res2 = Math.abs(o2 - mediana);
                return res1 - res2;
            }
        };

        Arrays.sort(array, compareByMediana);

        return array;
    }
}
