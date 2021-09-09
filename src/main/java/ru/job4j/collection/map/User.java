package ru.job4j.collection.map;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
   public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
               Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }

    public static void main(String[] args) {
        HashMap<User, String> map = new HashMap<>();
        User user = new User("Mike", 25, new GregorianCalendar(2021, Calendar.OCTOBER, 6));
        User user1 = new User("Mike", 25, new GregorianCalendar(2021, Calendar.OCTOBER, 6));

        map.put(user, "123");
        map.put(user1, "123");

        for (Map.Entry<User, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        /*
        В данном примере я добавил в мапу два одинаовых обьекта,
        при этом я не переопределял методы equals and hashcode
        поэтому мапа отработала не верно, она вывела на консоль два одинаковых ключа
        и одинаковые значение. Должна была перезаписать ключ и вывести на результат.
        Обьекты попали в одну корзину
         */


        /*
        При переопределении метода HasCode но не переопределяя метод equals  -
        с помощью этого метода мы узнаем индекс в массиве
        мапы далее если индексы равны то определяем обьекты в один бакет и перезаписываем данные по ключу
        метод equals не вызывается  в обьекте User так как он не переопределен
         */


        /*
        При переопределении метода equals сравниваются два одинаковых обьекта
        при сравнении они true, но при вызове hashcode они попадут в разные корзины
        так как метод вернет разные индексы обьектов
         */

        /*
        При переопределнии методов hashcode and equals - происходит сначало выполнение
        метода hashcode он вычисляет индекс обьектов далее если они одинаковые то происходит
        сравнение через метод equals если обеькты равны то ключи перезаписываются
         */
    }
}
