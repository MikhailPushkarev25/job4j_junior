package ru.job4j.io;

import org.junit.Test;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgsNameTest {




    @Test(expected = IllegalArgumentException.class)
    public void whenGetNotExist() {
        ArgsName jvm = ArgsName.of(new String[] {});
        jvm.get("Xmx");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongSomeArgument() {
        ArgsName jvm = ArgsName.of(new String[] {"-enconding=UTF-8", "-Xmx="});
    }

}