package ru.job4j.storage;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User value) {
        store.add(value);
    }

    @Override
    public boolean replace(String id, User value) {
        return store.replace(id, value);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
