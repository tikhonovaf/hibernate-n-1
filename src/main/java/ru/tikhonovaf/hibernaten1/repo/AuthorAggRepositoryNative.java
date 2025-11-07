package ru.tikhonovaf.hibernaten1.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tikhonovaf.hibernaten1.entity.Author;

import java.util.List;

@Repository
public interface AuthorAggRepositoryNative extends JpaRepository<Author, Long> {

    @Query(value = """
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
            ) AS books

        FROM author a
        LEFT JOIN book b ON b.author_id = a.id
        GROUP BY a.id, a.name
        ORDER BY a.id
        """,
            nativeQuery = true)
//    List<Object[]> fetchAuthorsFull();
    List<Author> fetchAuthorsFull();
}
