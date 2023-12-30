package com.bookStore.VirtualBookStore.Controller;

import com.bookStore.VirtualBookStore.Entity.Book;
import com.bookStore.VirtualBookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable Long id){

        return bookService.deleteBookById(id);

    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping("updateBookById/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newBookData){

        return bookService.updateBookById(id, newBookData);

    }

}
