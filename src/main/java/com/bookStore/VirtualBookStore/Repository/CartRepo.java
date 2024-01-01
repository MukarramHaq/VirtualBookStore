package com.bookStore.VirtualBookStore.Repository;

import com.bookStore.VirtualBookStore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}
