package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {  //d:/file.txt
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            while ((line = fileReader.readLine()) != null) {
                String lineRevers = new StringBuilder(line).reverse().toString();
                System.out.println(lineRevers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
