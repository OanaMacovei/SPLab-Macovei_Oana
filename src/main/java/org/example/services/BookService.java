package org.example.services;

import org.example.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    public Map<Integer, Book> books = new HashMap<>();
    int idCounter = 1;

    public BookService() {
        Book sampleBook = new Book("Design Patterns");
        books.put(1, sampleBook);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public Book createBook(Book book) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int id = idCounter++;
        books.put(id, book);
        return book;
    }

    public Book updateBook(int id, Book book) {
        books.put(id, book);
        return book;
    }

    public boolean deleteBook(int id) {
        if (id != 0) {
            books.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
