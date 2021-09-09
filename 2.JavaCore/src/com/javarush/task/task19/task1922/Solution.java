package com.javarush.task.task19.task1922;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            String lineReady;
            String[] splitLine;
            int count = 0;

            while ((lineReady = fileReader.readLine()) != null) {
                splitLine = lineReady.split(" ");

                for (String word : splitLine) {
                    if (words.contains(word)) {
                        count++;
                    }
                }
                if (count == 2) {
                    System.out.println(lineReady);
                }
                count = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
