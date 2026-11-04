package org.example.services;

import org.example.Book;
import org.example.persistence.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    //public Map<Integer, Book> books = new HashMap<>();
    public CrudRepository<Book, Long> booksRepository;

    public BookService(CrudRepository<Book, Long> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book getBookById(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return booksRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (booksRepository.existById(id)) {
            book.setId(id);
            return booksRepository.save(book);
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        if (booksRepository.existById(id)) {
            booksRepository.deletedById(id);
            return true;
        }
        return false;
    }
}
