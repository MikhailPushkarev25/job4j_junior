package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           String line;
           while (in.ready()) {
               line = in.readLine();
               String[] str = line.split(" ");
               if (str[str.length - 2].equals("404")) {
                   result.add(line + System.lineSeparator());
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.print(log);
    }
}
