package ru.job4j.generics;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Programmer extends Person {

    public Programmer(String name, int age, Date birthday) {
        super(name, age, birthday);
    }

    public Programmer() {

    }


    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args) {
        List<Person> per = List.of(
                new Person("Mikhail", 25, new Date(1995L))
        );
        new Programmer().printInfo(per);

        List<Programmer> prog = List.of(
                new Programmer("Roman", 30, new Date(1993L))
        );
        new Programmer().printInfo(prog);
    }
}
