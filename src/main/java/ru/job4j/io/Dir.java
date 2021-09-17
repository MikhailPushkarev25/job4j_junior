package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File(args[0]);

        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar ROOT_FOLDER");
        }

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format(
                    "Not exists %s", file.getAbsolutePath()));
        }

        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format(
                    "Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size: %s ", file.getTotalSpace()));
        for (File subFile : file.listFiles()) {
            System.out.println(subFile.getName() + " -> " + file.length());
        }
    }
}
