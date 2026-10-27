package org.example.commands;

import org.example.Book;
import org.example.services.BookService;

public class CreateBookCommand implements Command<Book>{
    public BookService booksService;
    private final Book book;

    public CreateBookCommand(BookService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.createBook(book);
    }
}
