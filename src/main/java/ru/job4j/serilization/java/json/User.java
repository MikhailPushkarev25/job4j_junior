package ru.job4j.serilization.java.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class User {
    private final boolean flag;
    private final String name;
    private final int age;
    private final Names names;
    private final int[] numbers;

    public User(boolean flag, String name, int age, Names names, int... numbers) {
        this.flag = flag;
        this.name = name;
        this.age = age;
        this.names = names;
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "User{"
                + "flag=" + flag
                + ", name='" + name + '\''
                + ", age=" + age
                + ", names=" + names
                + ", numbers=" + Arrays.toString(numbers)
                + '}';
    }

    public static void main(String[] args) {
        final User user = new User(
                false, "Mikhail", 25, new Names("Roman"), 1, 2, 3, 4, 5);

        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(user));

        String userGson =
                "{"
                    + "\"flag\":false,"
                    + "\"name\":Mikhail,"
                        + "\"age\":25,"
                        + "\"user\":"
                       + "{"
                             + "\"names\":\"Roman\""
                       + "},"
                    + "\"numbers\":"
                        + "[\"1\", \"2\", \"3\", \"4\", \"5\"]"
                + "}";

        final User userMode = gson.fromJson(userGson, User.class);
        System.out.println(userMode);
    }
}
