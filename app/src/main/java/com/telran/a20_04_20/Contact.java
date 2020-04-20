package com.telran.a20_04_20;

import java.util.Objects;
import java.util.UUID;

public class Contact {
    private String id;
    private String name;
    private String phone;
    private int key;

    public Contact(String name, String phone) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
    }

    public Contact(String name, String phone, int key) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
        this.key = key;
    }

    public int key() {
        return this.key;
    }

    public Contact(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String phone() {
        return this.phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
