package org.example.commands;

import org.example.Book;
import org.example.services.BookService;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>>{
    public BookService booksService;

    public GetAllBooksCommand(BookService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.getAllBooks();
    }
}
