package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenExpectedPut() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Mikle");
        map.put(2, "Roman");
        map.put(3, "Bob");
        assertThat(map.get(1), is("Mikle"));
    }


    @Test
    public void whenExpectedIteratorThenArrays() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Mikhail");
        map.put(2, "Roman");
        Iterator<Integer> it = map.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is(1));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(2));

    }

    @Test(expected = NoSuchElementException.class)
    public void whenExpectedElement() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.get(5);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenExpectedElementIterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenExpectedConcurrentElement() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Mikhail");
        map.put(2, "Roman");
        Iterator<Integer> it = map.iterator();
        map.put(5, "RGBT");
        it.next();
    }
}