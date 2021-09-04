package ru.job4j.collection;

import java.awt.desktop.AppReopenedEvent;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;
    private int size;

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value, null);
        node.next = head;
        head = node;
        size++;
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
       size--;
        head = first;
       return result;
    }

    public T deleteLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        T second = (T) last.value;
           last = last.prev;

        size--;
        return second;
    }

    public boolean revert() {
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> current = head;
        Node<T> second = null;
        while (current != null) {
            Node<T> next = current.next;
            current.next = second;
            second = current;
            current = next;
        }
        head = second;
        return true;
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

    public int getSize() {
        return size;
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
