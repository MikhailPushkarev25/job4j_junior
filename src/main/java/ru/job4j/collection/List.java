package ru.job4j.collection;

public interface List<E> extends Iterable<E> {

    void addLast(E value);

    E get(int index);
}
