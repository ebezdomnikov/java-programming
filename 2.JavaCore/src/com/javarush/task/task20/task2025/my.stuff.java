//package com.javarush.task.task20.task2025;
//
//import java.util.*;
//
///*
//Алгоритмы-числа
//*/
//public class Solution1 {
//    public static long[] getNumbers(long N) {
//        long[] result = null;
//        ArrayList<Long> list = new ArrayList();
//
//        //Degree[123,j] = 1j + 2j + 3j
//        Long[][] knownStepen = new Long[10][String.valueOf(Long.MAX_VALUE).length()];
//
//        HashMap<String,Long> knownHalfSumsInPow = new HashMap<>();
//        HashMap<String,Long> knownSums = new HashMap<>();
//
//        int operations = 0;
//
//        for (long i=0; i<=N; i++) {
//
//            int m = String.valueOf(i).length();
//
//            String numbers = String.valueOf(i);
//
//
//            char[] armstongNumber = numbers.toCharArray();
//            Arrays.sort(armstongNumber);
//            String armstrongKey = String.valueOf(armstongNumber);
//
//
//            long sum = 0;
//
//            if (knownSums.get(armstrongKey) == null) {
//
//                String halfSumByPow = "";
//
//                for (int digitIndex = 0; digitIndex < numbers.length(); digitIndex++) {
//
//                    halfSumByPow += numbers.substring(digitIndex, digitIndex + 1);
//
//                    if (knownHalfSumsInPow.get(halfSumByPow+":"+m) == null) {
//
//                        int digit = Integer.parseInt(numbers.substring(digitIndex, digitIndex + 1));
//
//                        int pow = m;
//
//                        double calc;
//
//                        if (knownStepen[digit][pow] == null) {
//
//                            calc = pow(Integer.parseInt(numbers.substring(digitIndex, digitIndex + 1)), m);
//                            knownStepen[digit][pow] = (long) calc;
//
//                        } else {
//                            calc = knownStepen[digit][pow];
//                        }
//
//                        sum += calc;
//
//                        knownHalfSumsInPow.put(halfSumByPow + ":" + m, sum);
//                    } else {
//                        sum = knownHalfSumsInPow.get(halfSumByPow+":"+m);
//                    }
//                }
//                operations++;
//                knownSums.put(armstrongKey,sum);
//
//            } else {
//                sum = knownSums.get(armstrongKey);
//            }
//
//            if (sum == i) {
//                list.add(sum);
//                System.out.println(numbers + " -> " + sum);
//            }
//
//            //370 = 3*3*3 + 7*7*7 + 0*0*
//
//        }
//        System.out.println(operations);
//
//        result = new long[list.size()];
//
//        for(int j=0; j<list.size(); j++) {
//            result[j] = list.get(j);
//        }
//
////        for (int k=0; k<10; k++) {
////            for (int l=0; l< String.valueOf(Long.MAX_VALUE).length(); l++)
////            {
////                System.out.print(knownStepen[k][l] + " | ");
////            }
////            System.out.println();
////        }
//
////        Map<String, Long> treeMap = new TreeMap<String, Long>(knownHalfSumsInPow);
////
////        for(Map.Entry<String, Long> entry : treeMap.entrySet()) {
////
////            System.out.println(entry.getKey() + ": " + entry.getValue());
////
////        }
//
//
//        return result;
//    }
//
//    //Это работает в разы быстрее Math.pow()
//    public static long pow (int num, int exp) {
//        long l = 1;
//        for (int i = 0; i < exp; i++)
//            l *= (long)num;
//
//        return l;
//
//    }
//
//
//    public static void main(String[] args)
//    {
//        final long startTime = System.currentTimeMillis();
//        //System.out.println(String.valueOf(Long.MAX_VALUE).length());
//        getNumbers(Long.MAX_VALUE);
//
//        double used  = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
//
//        System.out.println("Memory Used:" + used );
//        final long endTime = System.currentTimeMillis();
//        System.out.println("Total execution time: " + (endTime - startTime) );
//    }
//}
