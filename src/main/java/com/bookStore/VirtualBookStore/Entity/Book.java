package com.bookStore.VirtualBookStore.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private String authorName;
    private String description;


}
