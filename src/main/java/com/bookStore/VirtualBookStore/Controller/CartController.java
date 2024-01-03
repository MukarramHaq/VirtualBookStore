package com.bookStore.VirtualBookStore.Controller;

import com.bookStore.VirtualBookStore.Entity.Book;
import com.bookStore.VirtualBookStore.Entity.Cart;
import com.bookStore.VirtualBookStore.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/addToCart/{bookId}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long bookId){
        return cartService.addToCart(bookId);
    }

    @DeleteMapping("/removeBookById/{bookId}")
    public ResponseEntity<Cart> removeBookById(@PathVariable Long bookId){
        return cartService.removeBookById(bookId);
    }

    @DeleteMapping("/clearCart")
        public ResponseEntity<Cart> clearCart(){
            return cartService.clearCart();
        }

}
