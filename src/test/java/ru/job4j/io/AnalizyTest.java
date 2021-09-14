package ru.job4j.io;

import org.junit.Test;

import javax.swing.plaf.DimensionUIResource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenCopyFile() {
        String source = "./src/main/source.txt";
        String target = "./src/main/target.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(list.contains("10:57:01 10:59:01"), is(true));
        assertThat(list.contains("11:01:02 11:02:02"), is(true));
    }
}