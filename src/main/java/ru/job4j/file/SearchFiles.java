package ru.job4j.file;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SearchFiles {

    public void attribute(String[] args) {
        ArgsName argsName = ArgsName.of(args);

        if (args.length < 4) {
            throw  new IllegalArgumentException("Не указан аргумент");
        }

        if (argsName.get("d") == null) {
            throw new IllegalArgumentException("Не указана директория");
        }

        if (argsName.get("n") == null) {
            throw new IllegalArgumentException("Нет имя файла");
        }

        if (argsName.get("o") == null) {
            throw new IllegalArgumentException("нет файла");
        }
    }

    public void files(String[] pat) {
        attribute(pat);
        ArgsName argsName = ArgsName.of(pat);
        Path path = Paths.get(argsName.get("d"));
        try {
            List<Path> list = Search.search(
                    path, p -> p.toFile().getPath().equals(argsName.get("n")));
            for (Path p : list) {
                System.out.println(p.getFileName());
                PrintWriter pw = new PrintWriter(
                        new BufferedOutputStream(new FileOutputStream("o")));
                pw.println(p.getFileName().toString());
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SearchFiles files = new SearchFiles();
        files.files(args);
    }
}
