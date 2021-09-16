package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> second;
    private int size = 0;
    private int modCount = 0;

    @Override
    public void addLast(E value) {

       Node<E> e = second;
       Node<E> node = new Node<>(null, value, e);
       second = node;
       if (e == null) {
           first = node;
       } else {
           e.next = node;
       }
       size++;
       modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
                node = node.next;

        }
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> result = first;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return result != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E node = result.item;
                result = result.next;

                return node;
            }
        };
    }

    public class Node<T> {

         private T item;
         private Node<E> prev;
         private Node<E> next;

        public Node(Node<E> next, T item, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}
