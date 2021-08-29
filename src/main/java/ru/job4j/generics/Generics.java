package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal("Tiger", "mammals", new Date(1020292L)));
        second.add(new Predator("tigrolef", "smoky", new Date(274742742L)));
        third.add(new Tiger("tag", "spotted", new Date(838358357L)));

        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();

        generics.printBoundedWildCard(first);
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();

        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
        generics.printLowerBoundedWildCard(third);

    }
        public void printObject(List<?> obj) {
            for (Iterator<?> it = obj.iterator(); it.hasNext();) {
                Object object = it.next();
                System.out.println("Текущий элемент: " + object);
            }
        }

        public void printBoundedWildCard(List<? extends Animal> list) {
        for (Iterator<? extends Animal> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
        }

    public void printLowerBoundedWildCard(List<? super Tiger> list) {
        for (Iterator<? super Tiger> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

}
