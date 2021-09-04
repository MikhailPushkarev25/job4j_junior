package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ForwardLinkedTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(1);
        linked.addFirst(2);
        assertThat(linked.deleteFirst(), is(1));
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(1);
        linked.addFirst(2);
        Iterator<Integer> iterator = linked.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(1);
        linked.addFirst(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenSize0ThenReturnFalse() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        assertFalse(linked.revert());
    }

    @Test
    public void whenSize1ThenReturnFalse() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(1);
        assertFalse(linked.revert());
    }
}