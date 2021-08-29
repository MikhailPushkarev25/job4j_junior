package ru.job4j.storage;

public interface Store<T extends Base> {

    void add(T value);

    boolean replace(String id, T value);

    boolean delete(String id);

    T findById(String id);
}
