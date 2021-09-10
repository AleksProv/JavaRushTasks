package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    public static void main(String[] args) {
        try (FileOutputStream fileOutput = new FileOutputStream("data2.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fileOutput);
             FileInputStream fis = new FileInputStream("data2.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            Solution solution = new Solution("data.bin");
            solution.writeObject("Text");
            
            oos.writeObject(solution);
            oos.flush();

            Solution loadObject = (Solution) ois.readObject();
            loadObject.writeObject("Text 2");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
