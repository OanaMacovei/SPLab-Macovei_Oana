package org.example;

import java.util.ArrayList;
import java.util.List;

public class Book {
    String title;
    List<Author> authors = new ArrayList<>();
    List<Element> content = new ArrayList<>();
    public Book(String title) {
        this.title = title;
    }

    public void addContents(Element element) {
        this.content.add(element);
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
            element.print();
        }
    }
}
