package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addLast(T value) {
        Node<T> l = last;
        Node<T> node = new Node<>(l, value, null);
        last = node;
        if (l == null) {
            head = node;
        } else {
            l.next = node;
        }
    }

    public T deleteFirst() {
       T result;
       Node<T> first;
       if (head != null) {
           result = head.value;
           first = head.next;
       } else {
           throw new NoSuchElementException();
       }
        head = first;
       return result;
    }

    public T deleteLast() {
        T res;
        Node<T> second;
        if (last != null) {
            res = last.value;
            second = last.prev;
        } else {
            throw new NoSuchElementException();
        }
        last = second;
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = node.value;
                node = node.next;
                return result;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node<T> prev, T value, Node<T> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
