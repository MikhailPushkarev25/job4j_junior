package ru.job4j.auto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmRunAuto {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            Model one = Model.of("X3");
            Model two = Model.of("X5");
            Model three = Model.of("X6");
            Model four = Model.of("M5");
            Model five = Model.of("X1");

            Mark mark = Mark.of("BMW");
            mark.getModels().add(one);
            mark.getModels().add(two);
            mark.getModels().add(three);
            mark.getModels().add(four);
            mark.getModels().add(five);

            session.save(mark);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
