package ru.job4j.storage;

public class RoleStore implements Store<Role> {

    private Store<Role> role = new MemStore<>();

    @Override
    public void add(Role value) {
        role.add(value);
    }

    @Override
    public boolean replace(String id, Role value) {
        return role.replace(id, value);
    }

    @Override
    public boolean delete(String id) {
        return role.delete(id);
    }

    @Override
    public Role findById(String id) {
        return role.findById(id);
    }
}
