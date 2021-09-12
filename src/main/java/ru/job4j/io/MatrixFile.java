package ru.job4j.io;

import java.io.FileOutputStream;

public class MatrixFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("Matrix.txt")) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    out.write((i + " * " + j + " = " + i * j + System.lineSeparator()).getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
