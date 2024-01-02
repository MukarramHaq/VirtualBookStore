package com.bookStore.VirtualBookStore.Repository;

import com.bookStore.VirtualBookStore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
}
