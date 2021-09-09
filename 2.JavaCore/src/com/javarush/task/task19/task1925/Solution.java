package com.javarush.task.task19.task1925;

import java.io.*;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
//        String nameFile1 = "d:/words.txt";
//        String nameFile2 = "d:/words2.txt";
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(nameFile1, Charset.forName("windows-1251")));
//             FileWriter fileWriter = new FileWriter(nameFile2)) {
            String lineReady;
            String[] splitLine;

            while ((lineReady = fileReader.readLine()) != null) {
                splitLine = lineReady.split(" ");
                for (String word : splitLine) {
                    if (word.length() > 6) {
                        stringBuffer.append(word).append(",");
                    }
                }
            }

            stringBuffer.setLength(stringBuffer.length()-1);
            fileWriter.write(stringBuffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
