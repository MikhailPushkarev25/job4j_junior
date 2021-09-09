package ru.job4j.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void whenDemonstrationTestPersons() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person("Mikhail", 25));
        map.put(2, new Person("Roman", 30));
        assertThat(map.get(1), is("<Person{name='Mikhail', age=25}>"));
    }
}