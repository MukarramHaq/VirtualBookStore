package com.bookStore.VirtualBookStore.Service;

import com.bookStore.VirtualBookStore.Entity.Book;
import com.bookStore.VirtualBookStore.Entity.Cart;
import com.bookStore.VirtualBookStore.Repository.BookRepo;
import com.bookStore.VirtualBookStore.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private BookRepo bookRepo;

    public ResponseEntity<Cart> addToCart(Long bookId){

        Cart cart = cartRepo.findById(12).orElse(new Cart());
        Optional<Book> optionalBook = bookRepo.findById(bookId);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            cart.getBookList().add(book);
            Integer updatedTotal = (cart.getTotalPrice() == null ? 0 : cart.getTotalPrice()) + book.getPrice();
            cart.setTotalPrice(updatedTotal);
            cart.setTotalPrice(updatedTotal);
            return new ResponseEntity<>(cartRepo.save(cart), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<Cart> removeBookById(Long bookId){

        Cart cart = cartRepo.findById(12).orElse(new Cart());
        Book deletedBook = bookRepo.findById(bookId).get();
        List<Book> bookList = cart.getBookList();
        bookList.remove(deletedBook);
        Integer updatedTotal = cart.getTotalPrice() - deletedBook.getPrice();
        cart.setTotalPrice(updatedTotal);

        return new ResponseEntity<>(cartRepo.save(cart), HttpStatus.OK);

    }

}
