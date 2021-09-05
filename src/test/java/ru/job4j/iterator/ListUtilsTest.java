package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
         ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2 ,3);
        assertThat(Arrays.asList(0, 1, 2, 3), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 5, 1);
    }

    @Test
    public void whenRemoveElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeIf(input, i -> i > 1);
        assertThat(Arrays.asList(1), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveWithInvalid() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeIf(input, i -> i > 6);
    }

    @Test
    public void whenReplaceElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.replaceIf(input, i -> i > 2, 10);
        assertThat(Arrays.asList(1, 2, 10), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenReplaceElInvalid() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.replaceIf(input, i -> i > 10, 100);
    }

    @Test
    public void whenRemoveAllElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.removeAll(input, Arrays.asList(4, 5));
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveAllInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.removeAll(input, Arrays.asList(6, 7, 8, 9, 10));
    }
}