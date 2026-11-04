package org.example.commands;

import org.example.Book;
import org.example.services.BookService;

import java.util.List;

public class GetBookByIdCommand implements Command<Book> {
    public BookService booksService;
    Long id;

    public GetBookByIdCommand(BookService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Book execute() {
        return booksService.getBookById(id);
    }
}
