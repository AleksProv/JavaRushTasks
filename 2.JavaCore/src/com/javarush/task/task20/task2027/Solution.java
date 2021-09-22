package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        Word word1 = new Word(words[1]);
        StringBuffer strRight = new StringBuffer();
        StringBuffer strDown = new StringBuffer();
        StringBuffer strLeft = new StringBuffer();
        StringBuffer strLeftDown = new StringBuffer();
        StringBuffer strLeftUp = new StringBuffer();
        StringBuffer strUp = new StringBuffer();
        StringBuffer strRightUp = new StringBuffer();
        StringBuffer strRighDown = new StringBuffer();

        char first = words[1].charAt(0);


        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {

                if (first == crossword[i][j]) {
                    strLeftDown.append((char) crossword[i][j]);
                    for (int k = 1; k < crossword.length - 1; k++) {
                        if (j - k >= 0) {
                            strLeftDown.append((char) crossword[i + k][j - k]);
                        }
                    }
                }

                if (first == crossword[i][j]) {
                    strRightUp.append((char) crossword[i][j]);
                    for (int k = 1; k > 0; k--) {
                        if (j + k < crossword[i].length) {
                            strRightUp.append((char) crossword[i - k][j + k]);
                        }
                    }
                }


                if (first == crossword[i][j]) {
                    strLeftUp.append((char) crossword[i][j]);
                    for (int k = 1; k > 0; k--) {
                        if (j - k >= 0) {
                            strLeftUp.append((char) crossword[i - k][j - k]);
                        }
                    }
                }

                if (first == crossword[i][j]) {
                    strRighDown.append((char) crossword[i][j]);
                    for (int k = 1; k < crossword[i].length; k++) {
                        if (j + k < crossword[i].length - 1) {
                            strRighDown.append((char) crossword[i + k][j + k]);
                        }
                    }
                }

                if (first == crossword[i][j]) {
                    strLeft.append((char) crossword[i][j]);
                    for (int k = j; k > 0; k--) {
                        if (j - k >= 0) {
                            strLeft.append((char) crossword[i][j - k]);
                        }
                    }
                }

                if (first == crossword[i][j]) {
                    strUp.append((char) crossword[i][j]);
                    for (int k = i; k > 0; k--) {
                        if (i - k >= 0) {
                            strUp.append((char) crossword[i - k][j]);
                        }
                    }
                }
                if (first == crossword[i][j]) {
                    strRight.append((char) crossword[i][j]);
                    for (int k = 1; k < crossword[i].length; k++) {
                        if (j + k < crossword[i].length) {
                            strRight.append((char) crossword[i][j + k]);
                        }
                    }
                }
                if (first == crossword[i][j]) {
                    strDown.append((char) crossword[i][j]);
                    for (int k = 1; k < crossword[i].length; k++) {
                        if (i + k < crossword[i].length - 1) {
                            strDown.append((char) crossword[i + k][j]);
                        }
                    }
                }
            }
        }
        System.out.println(strRight);
        System.out.println(strRighDown);
        System.out.println(strDown);
        System.out.println(strLeftDown);
        System.out.println(strLeft);
        System.out.println(strLeftUp);
        System.out.println(strUp);
        System.out.println(strRightUp);

        return null;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
