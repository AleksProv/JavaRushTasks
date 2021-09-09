package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String line = outputStream.toString();
        System.setOut(printStream);
        String[] array = line.split("\n");
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 2 == 0) {
                System.out.println(array[i]);
                System.out.println("JavaRush - курсы Java онлайн");
            } else {
                System.out.println(array[i]);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
