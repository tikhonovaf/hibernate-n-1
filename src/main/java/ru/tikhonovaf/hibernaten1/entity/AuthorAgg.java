package ru.tikhonovaf.hibernaten1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("""
    SELECT 
        a.id,
        a.name,

        ARRAY(
            SELECT g.name 
            FROM author_genre ag
            JOIN genre g ON g.id = ag.genre_id
            WHERE ag.author_id = a.id
        ) AS genres,

        JSON_AGG(
            JSON_BUILD_OBJECT(
                'title', b.title,
                'publisher', b.publisher,
                'year', b.year
            ) ORDER BY b.title
        ) AS books_json

    FROM author a
    LEFT JOIN book b ON b.author_id = a.id
    GROUP BY a.id, a.name
""")

public class AuthorAgg {

    @Id
    private Long id;

    private String name;

    // PostgreSQL array → Java array
    @Column(columnDefinition = "text[]")
    private String[] genres;

    // JSON (string)
    @Column(columnDefinition = "json")
    private String booksJson;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String[] getGenres() { return genres; }
    public String getBooksJson() { return booksJson; }
}
