package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                stringWriter.write(line);
            }
        }
        return stringWriter;
    }
}

//        if (is != null) {
//        char[] buffer = new char[1024];
//        try (Reader reader = new BufferedReader(new InputStreamReader(is))) {
//        int n;
//        while ((n = reader.read(buffer)) != -1) {
//        writer.write(buffer, 0, n);
//        }
//        }
