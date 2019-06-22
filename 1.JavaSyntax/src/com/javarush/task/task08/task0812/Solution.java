package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listIntegers = new ArrayList();

        int countItems = 10;
        int itemsIterator = 0;

        while (itemsIterator < countItems)
        {
            listIntegers.add(Integer.parseInt(reader.readLine()));
            itemsIterator++;
        }

        itemsIterator = 0;
        int maxFreq = Integer.MIN_VALUE;
        int cnt = 1;
        while (itemsIterator < listIntegers.size()-1)
        {
            if (listIntegers.get(itemsIterator) == listIntegers.get(itemsIterator+1))
            {
                cnt++;
            }
            else
            {
                cnt = 1;
            }

            if (cnt > maxFreq)
            {
                maxFreq = cnt;
            }

            itemsIterator++;
        }

        System.out.print(maxFreq);
    }
}