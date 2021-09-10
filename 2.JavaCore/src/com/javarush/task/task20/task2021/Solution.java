package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        @Serial
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("Не сейчас");
        }

        @Serial
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException("Не сейчас");
        }
    }

    public static void main(String[] args) {
    }
}
