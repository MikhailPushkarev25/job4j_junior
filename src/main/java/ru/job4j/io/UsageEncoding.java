package ru.job4j.io;


import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class UsageEncoding {

    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new FileReader(path, Charset.forName("UTF-8")))) {
            br.lines().forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8")))) {
            data.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "./src/data/text.txt";
        UsageEncoding usageEncoding = new UsageEncoding();
        List<String> list = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );
            usageEncoding.writeDataInFile(path, list);
        String s = usageEncoding.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(s);
    }
}
