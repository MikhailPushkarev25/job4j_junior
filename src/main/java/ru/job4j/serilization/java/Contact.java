package ru.job4j.serilization.java;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");

        /* Запись обьекта во временный файл который удалиться системой **/
        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }

        /* Чтение лбьекта из файла*/
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ooi = new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ooi.readObject();
            System.out.println(contactFromFile);
        }
    }
}
