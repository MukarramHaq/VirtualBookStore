package com.bookStore.VirtualBookStore.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Cart {
    @Id
    private final Integer cartid = 12;
    @OneToMany
    @JoinTable(
            name = "cart_books",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> bookList = new ArrayList<>();

    private Integer totalPrice;

    public Cart() {
    }

    public Cart(List<Book> bookList, Integer totalPrice) {
        this.bookList = bookList;
        this.totalPrice = totalPrice;
    }


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartid=" + cartid +
                ", bookList=" + bookList +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
