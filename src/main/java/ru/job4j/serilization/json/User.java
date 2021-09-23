package ru.job4j.serilization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Names getNames() {
        return names;
    }

    public int[] getNumbers() {
        return numbers;
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
        JSONObject jsonNames = new JSONObject("{\"names\":\"Mikhail\"}");

        List<String> list = new ArrayList<>();
        list.add("Roman");
        list.add("Nikolay");
        JSONArray jsonArray = new JSONArray(list);

        User user = new User(false, "Ola", 25, new Names("Oleg"), 1, 2, 3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", user.isFlag());
        jsonObject.put("name", user.getName());
        jsonObject.put("age", user.getAge());
        jsonObject.put("names", jsonNames);
        jsonObject.put("numbers", jsonArray);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(user).toString());
    }
}
