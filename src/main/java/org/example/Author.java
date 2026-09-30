package org.example;

public class Author {
    String name, surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public void print() {
        System.out.println("Author: " + this.surname + this.name);
    }
}
