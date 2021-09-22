package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Алгоритмы-числа
*/


// Нужно оптимизировать на вывод результата меньше 10 секунд

public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (i < 10) {
                arrayList.add((long) i);
            } else {
                long summa = 0;
                String number = String.valueOf(i);
                int[] array = new int[number.length()];
                for (int k = 0; k < number.length(); k++) {
                    int numIndex = Character.digit(number.charAt(k), 10);
                    array[k] = numIndex;
                }
                for (int pear : array) {
                    summa = summa + (long) Math.pow(pear, number.length());
                }
                if (i == summa) {
                    arrayList.add(summa);
                }
            }
        }
        long[] result = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        Arrays.sort(result);
        return result;
    }


    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1_000_000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
