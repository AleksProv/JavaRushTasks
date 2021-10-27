package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream by = new ByteArrayOutputStream();
        String characters1 = "qwertyuioplkjhgfdsazxcvbnm";
        String characters2 = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        String characters3 = "0123456789";
        int length = 8;
        Random random = new Random();
        char[] text = new char[length];

        for (int i = 0; i < length; i++) {
            text[i] = characters1.charAt(random.nextInt(characters1.length()));
            by.write(text[i]);
            text[i] = characters2.charAt(random.nextInt(characters2.length()));
            by.write(text[i]);
            text[i] = characters3.charAt(random.nextInt(characters3.length()));
            by.write(text[i]);
        }

        byte[] array = by.toByteArray();
        by.reset();
        by.write(array, 0, length);

        return by;
    }
}

//  вариант JavaRash
//    ByteArrayOutputStream is = new ByteArrayOutputStream();
//    Basket[] baskets = new Basket[3];
//        baskets[0] = new Basket('0', '9');
//                baskets[1] = new Basket('a', 'z');
//                baskets[2] = new Basket('A', 'Z');
//                int i = 0;
//                for (; i < 5; i++) {
//        int index = (int) (Math.random() * 3);
//        generateChar(is, baskets, index);
//        }
//        for (int j = 0; j < baskets.length; j++) {
//        if (!baskets[j].isSelected()) {
//        generateChar(is, baskets, j);
//        i++;
//        }
//        }
//
//        while (i < 8) {
//        int index = (int) (Math.random() * 3);
//        generateChar(is, baskets, index);
//        i++;
//        }
//        return is;
//        }
//
//private static void generateChar(ByteArrayOutputStream is, Basket[] baskets, int index) {
//        Basket basket = baskets[index];
//        is.write((char) basket.getRandom());
//        }
//
//public static class Basket {
//    int begin;
//    int quantity;
//    boolean selected;
//
//    private Basket(char begin, char end) {
//        this.begin = begin;
//        this.quantity = end - begin;
//    }
//
//    public int getRandom() {
//        return (int) (Math.random() * quantity) + begin;
//    }
//
//    public boolean isSelected() {
//        return selected;
//    }
//}