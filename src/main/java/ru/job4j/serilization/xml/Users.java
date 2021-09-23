package ru.job4j.serilization.xml;

import ru.job4j.question.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlAttribute
    private boolean flag;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;

    private String[] names;

    private Programmer programmer;

    public Users() { }

    public Users(boolean flag, String name, int age, Programmer programmer, String... names) {
        this.flag = flag;
        this.name = name;
        this.age = age;
        this.names = names;
        this.programmer = programmer;
    }

    @Override
    public String toString() {
        return "Users{"
                + "flag=" + flag
                + ", name='" + name
                + '\'' + ", age=" + age
                + ", names=" + Arrays.toString(names)
                + ", programmer=" + programmer
                + '}';
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Users users = new Users(
                true, "Mikhail", 26, new Programmer("Java"), "JavaScript", "Json");

        JAXBContext context = JAXBContext.newInstance(Users.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String result;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(users, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            Users xml = (Users) unmarshaller.unmarshal(reader);
            System.out.println(xml);
        }

    }
}
