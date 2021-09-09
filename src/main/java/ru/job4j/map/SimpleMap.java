package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements  Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = hash(key.hashCode());

        if (table[index] != null) {
            return false;
        } else {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return true;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));

        if (table[index] != null) {
            return table[index].value;
        }
            throw new NoSuchElementException();
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            return false;
        }
        table[index] = null;
        count--;
        modCount++;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int size = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                while (size < capacity && table[size] == null) {
                    size++;
                }
                return size < capacity && table[size] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[size++].key;
            }
        };
    }

    private int hash(int hashcode) {
      return hashcode ^ hashcode >> 16;
    }

    private int indexFor(int has) {
        return Math.abs(has) % capacity;
    }

    private void expand() {
       capacity = capacity * 2;
       table = new MapEntry[capacity];
       for (MapEntry<K, V> entry : table) {
           if (entry != null) {
               int sum = indexFor(hash(entry.key.hashCode()));
               table[sum] = entry;
           }
       }
       Arrays.copyOf(table, capacity);
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
