package ru.job4j.collection.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNotNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenSetUsers() {
        Set<User> set = new SimpleSet<>();
        User user = new User("Mikhail", 25);
        User user1 = new User("Mikhail", 25);
       assertTrue(set.add(user));
       assertTrue(set.contains(user));
       assertFalse(set.add(user));
       assertFalse(set.add(user1));
    }
}