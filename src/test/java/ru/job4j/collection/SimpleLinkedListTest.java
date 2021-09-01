package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    @Test
    public void whenAddAndGet() {
        List<Integer> list = new SimpleLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        assertThat(list.get(0), Is.is(1));
        assertThat(list.get(1), Is.is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromOutOfBoundThenExceptionThrown() {
        List<Integer> list = new SimpleLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.get(2);
    }
        @Test
        public void whenGetIteratorTwiceThenEveryFromBegin() {
            List<Integer> list = new SimpleLinkedList<>();
            list.addLast(1);
            list.addLast(2);

            Iterator<Integer> first = list.iterator();
            assertThat(first.hasNext(), Is.is(true));
            assertThat(first.next(), Is.is(1));
            assertThat(first.hasNext(), Is.is(true));
            assertThat(first.next(), Is.is(2));
            assertThat(first.hasNext(), Is.is(false));

            Iterator<Integer> second = list.iterator();
            assertThat(second.hasNext(), Is.is(true));
            assertThat(second.next(), Is.is(1));
            assertThat(second.hasNext(), Is.is(true));
            assertThat(second.next(), Is.is(2));
            assertThat(second.hasNext(), Is.is(false));
        }

        @Test(expected = ConcurrentModificationException.class)
        public void whenExpectedElementNext() {
        List<Integer> list = new SimpleLinkedList<>();
        list.addLast(1);
        list.addLast(2);

        Iterator<Integer> it = list.iterator();
        list.addLast(3);
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(false));

        }

        @Test(expected = NoSuchElementException.class)
        public void whenExpectedNoSuchEl() {
        List<Integer> list = new SimpleLinkedList<>();
        Iterator<Integer> it = list.iterator();
        list.addLast(null);
        it.next();
        }

    }

