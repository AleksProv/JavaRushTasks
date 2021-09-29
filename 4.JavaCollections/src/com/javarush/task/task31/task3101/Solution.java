package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {
    Map<String, File> map = new TreeMap<>();

    public static void main(String[] args)  {
        Solution sol = new Solution();
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        try {
            File resultFile = new File(resultFileAbsolutePath);
            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
            if (FileUtils.isExist(dest)) {
                FileUtils.deleteFile(dest);
            }
            FileUtils.renameFile(resultFile, dest);

            Files.walkFileTree(Paths.get(path), new MyVisitor(sol.map));

            for (Map.Entry<String, File> entry : sol.map.entrySet()) {
                copyFiles(entry.getValue(), dest);
            }
        } catch (IOException e) {
        }
    }

    public static void copyFiles(File sourceFile, File destFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile, true)) {
            int i;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }
            fos.write("\n".getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static class MyVisitor extends SimpleFileVisitor<Path> {
       public Map<String, File> map;

        public MyVisitor(Map<String, File> map) {
            this.map = map;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            File file = path.toFile();
            if (file.isFile()) {
                if (file.length() <= 50) {
                    map.put(path.toFile().getName(), path.toFile());
                }
            }
            return super.visitFile(path, attrs);
        }
    }
}
