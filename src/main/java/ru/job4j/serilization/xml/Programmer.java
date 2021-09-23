package ru.job4j.serilization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "name")
public class Programmer {

    @XmlAttribute
    private String name;

    public Programmer() {

    }

    public Programmer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Programmer{"
                + "name='" + name + '\''
                + '}';
    }
}
