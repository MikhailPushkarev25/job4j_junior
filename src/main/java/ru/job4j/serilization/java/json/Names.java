package ru.job4j.serilization.java.json;

public class Names {
    private String names;

    public Names(String names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Names{"
                + "names='" + names + '\''
                + '}';
    }
}
