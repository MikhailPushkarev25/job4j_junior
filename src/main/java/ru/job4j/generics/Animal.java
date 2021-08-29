package ru.job4j.generics;

import java.util.Date;
import java.util.Objects;

public class Animal {

    private String name;
    private String view;
    private Date birthday;

    public Animal(String name, String view, Date birthday) {
        this.name = name;
        this.view = view;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(view, animal.view) &&
                Objects.equals(birthday, animal.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, view, birthday);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", view='" + view + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
