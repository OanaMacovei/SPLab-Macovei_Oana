package org.example.controllers;

import org.example.Book;
import org.example.commands.CommandExecutor;
import org.example.commands.CreateBookCommand;
import org.example.commands.GetAllBooksCommand;
import org.example.commands.GetBookByIdCommand;
import org.example.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private BookService booksService;
    private CommandExecutor executor;

    public BooksController(BookService booksService, CommandExecutor executor) {
        this.booksService = booksService;
        this.executor = executor;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        GetAllBooksCommand cmd = new GetAllBooksCommand(booksService);
        return ResponseEntity.ok(executor.executeSynchronous(cmd));
    }
    // 2. GET /books/{id} - Sincron
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        GetBookByIdCommand cmd = new GetBookByIdCommand(booksService, id);
        Book book = executor.executeSynchronous(cmd);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    // 3. POST /books - Asincron (returneaza 202 ACCEPTED si un tracking ID)
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        CreateBookCommand cmd = new CreateBookCommand(booksService, book);
        String trackingId = executor.executeAsync(cmd);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Comanda acceptata spre procesare. Tracking ID: " + trackingId);
    }

    // Ruta suplimentara pentru verificarea statusului taskului asincron (Task 16.d)
    @GetMapping("/status/{trackingId}")
    public ResponseEntity<String> getAsyncStatus(@PathVariable String trackingId) {
        return ResponseEntity.ok(executor.getTaskStatus(trackingId));
    }

    // 4. PUT /books/{id} - Sincron
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updated = booksService.updateBook(id, book);
        return ResponseEntity.ok(updated);
    }

    // 5. DELETE /books/{id} - Sincron
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        boolean deleted = booksService.deleteBook(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
