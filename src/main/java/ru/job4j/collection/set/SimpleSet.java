package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private final SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
           set.add(value);
           return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
       boolean b = false;
       for (T result : set) {
           if (result.equals(value)) {
               b = true;
               break;
           }
       }
        return b;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
