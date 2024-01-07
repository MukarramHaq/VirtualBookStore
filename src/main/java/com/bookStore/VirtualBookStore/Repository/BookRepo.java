package com.bookStore.VirtualBookStore.Repository;

import com.bookStore.VirtualBookStore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    public List<Book> findByBookNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String key1, String key2);

}
