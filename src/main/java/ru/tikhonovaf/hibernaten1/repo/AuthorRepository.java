package ru.tikhonovaf.hibernaten1.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.tikhonovaf.hibernaten1.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // можно добавлять свои методы, например:
    // List<Author> findByNameContaining(String name);
}
