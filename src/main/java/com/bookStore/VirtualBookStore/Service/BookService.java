package com.bookStore.VirtualBookStore.Service;

import com.bookStore.VirtualBookStore.Entity.Book;
import com.bookStore.VirtualBookStore.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpResponse;
import java.util.*;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public ResponseEntity<Book> addBook(@RequestBody Book book){

        Book newBook = bookRepo.save(book);
        return new ResponseEntity<>(newBook, HttpStatus.OK);

    }

    public ResponseEntity<Book> deleteBookById(Long id){

        bookRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<List<Book>> getAllBooks(String searchKey){

        List<Book> bookList = new ArrayList<>(bookRepo.findAll());
        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }

    public ResponseEntity<Book> getBookById(Long id) {

        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<Book> updateBookById(Long id, Book newBookData){

        Optional<Book> oldData = bookRepo.findById(id);
        if(oldData.isPresent()){
            Book updatedBookData = oldData.get();
            updatedBookData.setBookName(newBookData.getBookName());
            updatedBookData.setAuthorName(newBookData.getAuthorName());
            updatedBookData.setDescription(newBookData.getDescription());
            updatedBookData.setPrice(newBookData.getPrice());

            Book savedDate = bookRepo.save(updatedBookData);
            return new ResponseEntity<>(savedDate, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}


