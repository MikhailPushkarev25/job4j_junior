package ru.job4j.serilization.xml;

import java.util.Arrays;

public class Users {

    private final boolean flag;
    private final String name;
    private final int age;
    private final String[] names;
    private final Programmer programmer;

    public Users(boolean flag, String name, int age, Programmer programmer, String... names) {
        this.flag = flag;
        this.name = name;
        this.age = age;
        this.names = names;
        this.programmer = programmer;
    }

    @Override
    public String toString() {
        return "Users{"
                + "flag=" + flag
                + ", name='" + name
                + '\'' + ", age=" + age
                + ", names=" + Arrays.toString(names)
                + ", programmer=" + programmer
                + '}';
    }

    public static void main(String[] args) {
        Users users = new Users(
                true, "Mikhail", 26, new Programmer("Java"), "JavaScript", "Json");
    }
}
