package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    String name, surname;

    public Author() {}

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public void print() {
        System.out.println("Author: " + this.surname + this.name);
    }
}
