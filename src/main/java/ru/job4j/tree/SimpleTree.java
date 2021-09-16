package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> par = findBy(parent);
        if (par.isPresent()) {
            Optional<Node<E>> ch = findBy(child);
            if (!ch.isPresent()) {
                Node node = par.get();
                node.children.add(new Node(child));
                rsl = true;
            }
        }

        return rsl;
    }

    @Override
    public boolean isBinary() {
        Optional<Node<E>> ch = findByPredicate(res -> res.children.size() > 2);
        return ch.isEmpty();
    }
    
    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
      return findByPredicate((v) -> v.value.equals(value));
    }
}
