package com.javarush.task.task31.task3102;


import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root)  {
        ArrayList<String> list = new ArrayList<>();
        Queue<Path> queue = new LinkedList<>();
        queue.offer(Paths.get(root));
        while (!queue.isEmpty()){
            File[] files = new File(queue.poll().toString()).listFiles();
            for (File file: files){
                if (file.isFile()){
                    list.add(file.getAbsolutePath());
                } else if (file.isDirectory()){
                    queue.offer(file.toPath());
                }
            }
        }
        return list;
    }

    public static void main(String[] args)  {
        String root = "D:/005";
        System.out.println(getFileTree(root));
    }

}
