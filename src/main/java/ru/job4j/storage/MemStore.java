package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T value) {
        mem.add(value);
    }

    @Override
    public boolean replace(String id, T value) {
       boolean b = false;
       for (int i = 0; i < mem.size(); i++) {
           if (id.equals(mem.get(i).getId())) {
               mem.set(i, value);
               b = true;
               break;
           }
       }
        return b;
    }

    @Override
    public boolean delete(String id) {
         boolean b = false;
         for (int i = 0; i < mem.size(); i++) {
             if (id.equals(mem.get(i).getId())) {
                 mem.remove(i);
                 b = true;
                 break;
             }
         }
         return b;
    }

    @Override
    public T findById(String id) {
       T rsl = null;
       for (T t : mem) {
           if (id.equals(t.getId())) {
               rsl = t;
               break;
           }
       }
        return rsl;
    }
}
