package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AbuseTest {

    @Rule
     public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws Exception {
        File source = folder.newFile("sour.txt");
        File target = folder.newFile("targ.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hello foolfish dude");
            out.println("java job4j php");
        }
        Abuse.drop(source.getAbsolutePath(), target.getAbsolutePath(), List.of("foolfish", "php"));
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("hello dude java job4j "));
    }
}