package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        //       String nameFile1 = "d:/sss.txt";
        //       String nameFile2 = "d:/sss2.txt";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
            String lineReady;
            String[] splitLine;
            while ((lineReady = fileReader.readLine()) != null) {
                splitLine = lineReady.split(" ");
                for (String pear : splitLine) {
                    if (pear.matches("(.*[0-9].*)")) {
                        fileWriter.write(pear + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
