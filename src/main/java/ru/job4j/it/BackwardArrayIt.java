package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {

    private final int[] data;
    private int point = 0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {

        return data.length >  point;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < data.length - 1; i++) {
            int j = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = j;
        }
        return data[point++];
    }
}
