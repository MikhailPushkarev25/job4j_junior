package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFileMode {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            br.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
