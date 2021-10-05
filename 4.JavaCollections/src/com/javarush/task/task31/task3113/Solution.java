package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        // 2 решение
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirName = reader.readLine();

        Path directory = Paths.get(dirName);

        if (!Files.isDirectory(directory)) {
            System.out.println(directory + " - не папка.");
        } else {
            AtomicInteger folderCounter = new AtomicInteger();
            AtomicInteger fileCounter = new AtomicInteger();
            AtomicLong sizeCounter = new AtomicLong();

            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!dir.equals(directory)) folderCounter.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCounter.incrementAndGet();
                    sizeCounter.addAndGet(attrs.size());
                    return FileVisitResult.CONTINUE;
                }
                @Override
                    public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
//                        System.out.printf("Невозможно получить размер файла %s%n%s", file, e);
                        return FileVisitResult.CONTINUE;
                    }

            });

            System.out.println("Параметры папки " + directory);
            System.out.println("Всего папок - " + folderCounter.get());
            System.out.println("Всего файлов - " + fileCounter.get());
            System.out.println("Общий размер - " + sizeCounter.get() + " байт");
        }
    }
}

// 1 решение
//        AtomicLong size = new AtomicLong(0);
//        long countFiles;
//        long countDir;
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String nameDir = reader.readLine();
//        Path pathDir = Paths.get(nameDir);
//        if (!Files.isDirectory(pathDir)) {
//            System.out.println(pathDir + " - не папка");
//        } else {
//
//            countFiles = Files.find(pathDir, Integer.MAX_VALUE, (path, basicFileAttributes) -> Files.isRegularFile(path)).count();
//            countDir = Files.find(pathDir, Integer.MAX_VALUE, (path, basicFileAttributes) -> Files.isDirectory(path)).count();
//
//            try {
//                Files.walkFileTree(pathDir, new SimpleFileVisitor<Path>() {
//                    @Override
//                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                        size.addAndGet(attrs.size());
//                        return FileVisitResult.CONTINUE;
//                    }
//
//                    @Override
//                    public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
//                        System.out.printf("Невозможно получить размер файла %s%n%s", file, e);
//                        return FileVisitResult.CONTINUE;
//                    }
//                });
//
//            } catch (IOException e) {
//                System.out.printf("Ошибка при подсчёте размера директории %s", e);
//            }
//
//            System.out.println("Параметры папки " + pathDir);
//            System.out.println("Всего папок - " + (countDir-1));
//            System.out.println("Всего файлов - " + countFiles);
//            System.out.println("Общий размер - " + size + " байт");
//        }
//    }
//}


