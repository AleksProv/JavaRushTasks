package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
//        String[] args2 = {"d:/zap3.txt", "2", "345"};
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long number = Long.parseLong(args[1]);
            long lenghtFile = raf.length();
            raf.seek(number);
            byte[] buffer = new byte[args[2].length()];
            raf.read(buffer, 0, args[2].length());
            String text = new String(buffer);
            System.out.println(text);
            raf.seek(lenghtFile);
            if (text.equals(args[2])) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
