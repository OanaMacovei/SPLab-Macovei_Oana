package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book extends Section{
    @Getter
    @ManyToMany(cascade = CascadeType.ALL)
    List<Author> authors = new ArrayList<>();

    @Transient
    List<Element> content = new ArrayList<>();
    public Book(String title) {
        super(title);
    }

    public Book() {}

    public void addContents(Element element) {
        this.content.add(element);
        super.add(element);
    }

    public void addAuthors(Author author) {
        this.authors.add(author);
    }

    @Override
    public String toString() {
        return "Book: " + this.title + "\n";
    }

    public void print() {
        System.out.println("Book: " + this.title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println("\n");
        for (Element element : content) {
            element.render();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
