package ru.tikhonovaf.hibernaten1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String publisher;

    private Integer year;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // getters/setters
}
