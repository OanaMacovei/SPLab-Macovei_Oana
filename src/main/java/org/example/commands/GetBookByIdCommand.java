package org.example.commands;

import org.example.Book;
import org.example.services.BookService;

import java.util.List;

public class GetBookByIdCommand implements Command<Book> {
    public BookService booksService;
    int id;

    public GetBookByIdCommand(BookService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Book execute() {
        return booksService.getBookById(id);
    }
}
